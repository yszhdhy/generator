package ${packageName}.generatorCRUD.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import ${packageCommonUtilName}.result.Result;
import ${packageName}.generatorCRUD.service.SysGeneratorService;
import ${packageName}.generatorCRUD.utils.GenUtils;
import ${packageName}.service.SysMenuService;
import ${packageName}.service.SysRoleMenuService;
import ${packageName}.service.SysRoleService;
import ${packageModelName}.model.SysMenu;
import ${packageModelName}.model.SysRole;
import ${packageModelName}.model.SysRoleMenu;
import io.swagger.annotations.ApiOperation;
import com.yszhdhy.generator.model.project.Project;
import org.dom4j.DocumentException;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/web")
public class CRUDPageWeb {

    @Autowired
    SysMenuService service;

    @Autowired
    SysGeneratorService sysGeneratorService;

    @Autowired
    SysRoleService sysRoleService;


    @Autowired
    SysRoleMenuService sysRoleMenuService;

    private Project project = null;


    @InitBinder
    public void builder() throws DocumentException, FileNotFoundException {
        project = new Project();
    }

    @GetMapping("/generatorTemplate/{id}")
    @ResponseBody
    public Result generatorTemplate(@PathVariable Integer id) throws DocumentException, IOException {

        generator(id);
        return Result.ok();
    }

    public void generator(Integer id) throws DocumentException, IOException {
        if(id == 0){
            project.generateVue2(); //生成vue2模版
        }else if(id==1){
            project.generateVue3(); // 生成vue3模版
        }
    }

    @GetMapping("/generatorBackEndModules/{id}")
    @ResponseBody
    public Result generatorBackEndModules(@PathVariable Integer id) throws DocumentException, IOException {

        generatorBackEnd(id);
        return Result.ok();
    }

    public void generatorBackEnd(Integer id) throws DocumentException, IOException {
        if(id == 0){
            project.generateSecurity(project.getInfo());
        } else if (id == 1) {
            project.generateMinio(project.getInfo());
        }else if(id == 2){
            project.generateElasticsearch(project.getInfo());
        }
    }

    @GetMapping("/template")
    @ResponseBody
    public Result template(){
        ArrayList<Template> templates = new ArrayList<>();
        templates.add(new Template(0,"vue2",
            "https://th.bing.com/th/id/OIP.9o6qo0FbaCnMvlqVDphm7QHaEN?w=305&h=180&c=7&r=0&o=5&dpr=1.8&pid=1.7","" +
            "vue2模版"));

        templates.add(new Template(1,"vue3",
            "https://th.bing.com/th/id/OIP.MZNBuXw1Ujk4VyOE127KoAHaEK?w=266&h=180&c=7&r=0&o=5&dpr=1.8&pid=1.7","" +
            "vue3模版"));
        return Result.ok(templates);
    }

    @GetMapping("/BackEndModules")
    @ResponseBody
    public Result BackEndModules(){
        ArrayList<Template> BackEndModules = new ArrayList<>();
        BackEndModules.add(new Template(0,"security",
            "https://th.bing.com/th/id/OIP.K-E-MGRRh0-WYOu1HUNOFgHaEt?w=264&h=180&c=7&r=0&o=5&dpr=1.8&pid=1.7","" +
            "security模块"));

        BackEndModules.add(new Template(1,"minio",
            "https://tse1-mm.cn.bing.net/th/id/OIP-C.RIDSUXsCfV8tpm7d_DpWCwHaEK?w=304&h=180&c=7&r=0&o=5&dpr=1.9&pid=1.7","" +
            "minio模块"));

        BackEndModules.add(new Template(2,"Elasticsearch",
            "https://th.bing.com/th/id/OIP.TFrudOLpgCRQjjk4b_dAywHaD2?w=339&h=180&c=7&r=0&o=5&dpr=1.8&pid=1.7","" +
            "Elasticsearch模块"));
        return Result.ok(BackEndModules);
    }

    @GetMapping("/crud")
    public String crud(Model model){

        LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysMenu::getType,0);  // 查询类型不为 2 的 为2 的是 按钮
        List<SysMenu> list = service.list(wrapper);


        List<String> databaseTableNames = GenUtils.getDatabaseTableNames();

        // 保存 表名信息
        ArrayList<Table> tableNames = new ArrayList<>();
        for (String tableName : databaseTableNames) {
            tableNames.add(new Table(tableName,new Date()));
            System.out.println("表名：" + tableName);
        }

        //        查询角色
        List<SysRole> sysRoleList = sysRoleService.list();

        System.out.println( tableNames );
        //展示的数据
        model.addAttribute("tableNames",tableNames);
        model.addAttribute("SysMenu",list);
        model.addAttribute("sysRoleList",sysRoleList);

        return "index";
    }

    @ApiOperation(value = "新增菜单")
    @ResponseBody // 返回数据
    @PostMapping("/save")
    public Result save(@RequestBody SysMenu sysMenu) throws IOException {
        System.out.println(sysMenu);

        LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysMenu::getPath,sysMenu.getPath());

        SysMenu one = service.getOne(wrapper);
        System.out.println(one);

        sysMenu.setParentId(one.getId());
        if(one.getType()==1){
            sysMenu.setType(one.getType()+2);
        }else{
            sysMenu.setType(one.getType()+1);
        }

        ArrayList<String> tableNames = new ArrayList<>();
        tableNames.add(sysMenu.getTableName());

        String[] array = tableNames.toArray(new String[0]);  // 表名称

//        将表名转换为java的类名称 也就是驼峰
        String javaTableName = GenUtils.tableToJava(sysMenu.getTableName(), new String[]{});

        String component = builderComponent(sysMenu.getParentId(),javaTableName);
        System.out.println(component);
        sysMenu.setComponent(component+"/"+javaTableName + "index");

        sysMenu.setPath("/"+convertSecondWordFirstLetterToLowercase(component)); //将首字母转为小写并设置

        System.out.println(sysMenu);

        // 保存
        service.save(sysMenu);

         //        之后查询插入表后的Id
         LambdaQueryWrapper<SysMenu> wrapper1 = new LambdaQueryWrapper<>();
            wrapper1.eq(SysMenu::getName,sysMenu.getName())
            .eq(SysMenu::getParentId,sysMenu.getParentId())
            .eq(SysMenu::getPath,sysMenu.getPath())
            .eq(SysMenu::getComponent,sysMenu.getComponent());
            SysMenu menu = service.getOne(wrapper1);

            // 创建 角色菜单关系对象
            for (Integer roleId : sysMenu.getRoleIds()) {
                SysRoleMenu sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setRoleId(Long.valueOf(roleId));
                sysRoleMenu.setMenuId(menu.getId());
                //将其保存进 角色菜单表中：
                sysRoleMenuService.save(sysRoleMenu);
             }

        sysGeneratorService.generatorCode(array,component,sysMenu);

        return Result.ok();

    }

    /**
    * 生成代码
    */
    @GetMapping("/code")
    public void code(SysMenu sysMenu, HttpServletResponse response) throws IOException{

        LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysMenu::getPath,sysMenu.getPath());

        SysMenu one = service.getOne(wrapper);
        System.out.println(one);

        sysMenu.setParentId(one.getId());
        if(one.getType()==1){
            sysMenu.setType(one.getType()+2);
        }else{
             sysMenu.setType(one.getType()+1);
         }

        ArrayList<String> tableNames = new ArrayList<>();
        tableNames.add(sysMenu.getTableName());

        String[] array = tableNames.toArray(new String[0]);  // 表名称

        //        将表名转换为java的类名称 也就是驼峰
        String javaTableName = GenUtils.tableToJava(sysMenu.getTableName(), new String[]{});

        String component = builderComponent(sysMenu.getParentId(),javaTableName);
        System.out.println(component);
        sysMenu.setComponent(component+"/"+javaTableName + "index");

        sysMenu.setPath("/"+convertSecondWordFirstLetterToLowercase(component)); //将首字母转为小写并设置

        System.out.println(sysMenu);

        byte[] data = sysGeneratorService.generatorCode(sysMenu.getTableName().split(","),component,sysMenu);

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"yszhdhy.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }

    public String builderComponent(Long id,String path){
        SysMenu menu = service.getById(id);
        if(menu.getParentId()!=0){
           return  builderComponent(menu.getParentId(),menu.getPath()+"/"+path);
        }else{
            return menu.getPath()+"/"+path;
        }

    }

    public static String convertSecondWordFirstLetterToLowercase(String input) {
        StringBuilder sb = new StringBuilder();

        // 找到第一个单词结束的位置
        int firstWordEndIndex = input.indexOf('/');
        if (firstWordEndIndex == -1) {
            return input; // 如果没有找到斜杠，直接返回原始字符串
        }

        // 将第一个单词直接添加到 StringBuilder 中
        sb.append(input.substring(0, firstWordEndIndex + 1));

        // 找到第二个单词的起始位置
        int secondWordStartIndex = firstWordEndIndex + 1;

        // 将第二个单词的首字母转换为小写并添加到 StringBuilder 中
        if (secondWordStartIndex < input.length()) {
            sb.append(Character.toLowerCase(input.charAt(secondWordStartIndex)));
            sb.append(input.substring(secondWordStartIndex + 1));
        }

            return sb.toString();
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Table{

        private String name;
        private Date date;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Template{
        private Integer id;
        private String name;
        private String imageUrl;
        private String des;
    }
}
