package com.yszhdhy.generator.construct.FileBuilderOfProject;

import com.yszhdhy.generator.constant.code.CodeTemplate;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.constant.common.pom.PomAttributeConstant;
import com.yszhdhy.generator.constant.common.yaml.YamlPath;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.commonUtil.JwtHelperBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.commonUtil.MD5Builder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.commonUtil.ResultBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.commonUtil.ResultCodeEnumBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.serviceUtil.GlobalExceptionHandlerBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.serviceUtil.GuiguExceptionBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.serviceUtil.Knife4jConfigBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.serviceUtil.MybatisPlusConfigBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.model.system.*;
import com.yszhdhy.generator.construct.FileBuilderOfProject.model.vo.*;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.SpringbootInitiate;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.controller.IndexControllerBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.controller.SysMenuControllerBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.controller.SysRoleControllerBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.controller.SysUserControllerBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.mapper.*;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.mapper.xml.SysMenuMapperXmlBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.mapper.xml.SysRoleMapperXmlBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.mapper.xml.SysUserMapperXmlBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.mapper.xml.SysUserRoleMapperXmlBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.pom.PomInitiate;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.service.*;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.service.impl.*;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.utils.MenuHelperBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.yaml.YamlInitiate;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.VueBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.build.buildBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.publicVue.FaviconBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.publicVue.IndexBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.AppBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.api.TableBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.api.UserBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.api.system.SysMenuBuilderVue;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.api.system.SysRoleBuilderVue;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.api.system.SysUserBuilderVue;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.assets.AssetsBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.components.Breadcrumb.BreadcrumbIndexBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.components.Hamburger.HamburgerIndexBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.components.ParentView.ParentViewIndexBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.components.SvgIcon.SvgIconIndexBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.icons.IconsIndexBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.icons.IconsSvgoBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.icons.svg.SvgBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.layout.LayoutBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.router.RouterBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.store.StoreBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.styles.StylesBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.utils.UtilsBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.views.ViewsBuilder;
import com.yszhdhy.generator.construct.build.FileBuilder.*;
import com.yszhdhy.generator.model.project.ProjectInfo;
import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.OtherNode;
import com.yszhdhy.generator.utils.MkdirFileWriteUtils;
import com.yszhdhy.generator.utils.PomAndYamlBuildMap;
import com.yszhdhy.generator.utils.PomUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 构建文件
 */
public class BuildTheFile {

    public static void construct(List<CodeTemplate> codeTemplateList, String filePath, String GroupId) throws IOException {

        MkdirFileWriteUtils.write(codeTemplateList,filePath,GroupId);
    }


    /**
     * 构建启动类 和 yaml
     * @param info
     * @throws IOException
     */
    public static void buildTheFile(ProjectInfo info) throws IOException, DocumentException {

        SpringbootInitiate.construct(info);


        //构建 yaml map
        Map<String, Object> map = new HashMap<>();
        map = PomAndYamlBuildMap.builderYaml(map, new MyBatisPlusBuilder());
        map = PomAndYamlBuildMap.builderYaml(map,new SpringBootParentBuilder());
        map = PomAndYamlBuildMap.builderYaml(map,new SpringBootWebBuilder());


        //构建 yaml
        YamlInitiate.construct(YamlPath.YAML_PATH.getYamlPath(), map);


        PomUtils.init(PackagePath.PACKAGE_COMMON_PATH.getPackagePath()+"/pom.xml");
        //构建 dependencies 集合
        List<Dependency> dependencies =new ArrayList<>();
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new SpringBootWebBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new LombokBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new ModelBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new ServiceUtilBuilder());


        //向pom中注入依赖
        PomInitiate.construct(PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/pom.xml",dependencies);


        //之后进行还要进行设置 parent 因为用户自己创建的 一个maven 不包含
        OtherNode otherNode = new OtherNode();
        otherNode.setParentNodeName("parent");

        List<OtherNode.Node> nodes = new ArrayList<>();
        nodes.add(new OtherNode.Node("groupId","org.springframework.boot"));
        nodes.add(new OtherNode.Node("artifactId","spring-boot-starter-parent"));
        nodes.add(new OtherNode.Node("version", PomAttributeConstant.POM_ATTRIBUTE_VERSION.getPomAttribute()));
        nodes.add(new OtherNode.Node("relativePath", ""));
        otherNode.setNodes(nodes);

        PomUtils.addOtherNodes(otherNode);

        PomUtils.addResource();


        //构建所有的文件
        serviceUtil();
        commonUtil();
        model();
        service();
        vue();
    }

    public static void serviceUtil() throws IOException {
        Knife4jConfigBuilder.construct();  // knife4j 配置文件
        MybatisPlusConfigBuilder.construct();  // Mybatis 配置文件
        GlobalExceptionHandlerBuilder.construct();  // GlobalExceptionHandler 配置文件
        GuiguExceptionBuilder.construct();  // GuiguException 配置文件
    }

    public static void commonUtil() throws IOException {
        JwtHelperBuilder.construct();  // JwtHelper 配置文件
        MD5Builder.construct();  // MD5 配置文件
        ResultBuilder.construct();  // Result 配置文件
        ResultCodeEnumBuilder.construct();  // ResultCodeEnum 配置文件
    }


    public static void model() throws IOException {
        SysMenuBuilder.construct();
        SysLoginLogBuilder.construct();
        SysOperLogBuilder.construct();
        SysRoleMenuBuilder.construct();
        SysPostBuilder.construct();
        SysRoleBuilder.construct();
        SysUserRoleBuilder.construct();
        SysUserbuilder.construct();
        BaseEntityBuilder.construct();

        AssginMenuVoBuilder.construct();
        AssginRoleVoBuilder.construct();
        LoginVoBuilder.construct();
        MetaVoBuilder.construct();
        RouterVoBuilder.construct();
        SysLoginLogQueryVoBuilder.construct();
        SysOperLogQueryVoBuilder.construct();
        SysPostQueryVoBuilder.construct();
        SysRoleQueryVoBuilder.construct();
        SysUserQueryVoBuilder.construct();
    }


    public static void service() throws IOException {
        IndexControllerBuilder.construct();
        SysMenuControllerBuilder.construct();
        SysRoleControllerBuilder.construct();
        SysUserControllerBuilder.construct();

        SysMenuMapperBuilder.construct();
        SysRoleMapperBuilder.construct();
        SysRoleMenuMapperBuilder.construct();
        SysUserMapperBuilder.construct();
        SysUserRoleMapperBuilder.construct();

        SysMenuMapperXmlBuilder.construct();
        SysRoleMapperXmlBuilder.construct();
        SysUserMapperXmlBuilder.construct();
        SysUserRoleMapperXmlBuilder.construct();

        // service
        SysMenuServiceBuilder.construct();
        SysRoleMenuServiceBuilder.construct();
        SysRoleServiceBuilder.construct();
        SysUserRoleServiceBuilder.construct();
        SysUserServiceBuilder.construct();

        //impl
        SysMenuServiceImplBuilder.construct();
        SysRoleMenuServiceImplBuilder.construct();
        SysRoleServiceImplBuilder.construct();
//        SysUserDetailsServiceImplBuilder.construct();
        SysUserRoleServiceImplBuilder.construct();
        SysUserServiceImplBuilder.construct();


        //utils
        MenuHelperBuilder.construct();

    }


    public static void vue() throws IOException {
        buildBuilder.construct();

        FaviconBuilder.construct();
        IndexBuilder.construct();

        SysMenuBuilderVue.construct();
        SysRoleBuilderVue.construct();
        SysUserBuilderVue.construct();
        TableBuilder.construct();
        UserBuilder.construct();

        BreadcrumbIndexBuilder.construct();
        HamburgerIndexBuilder.construct();
        ParentViewIndexBuilder.construct();
        SvgIconIndexBuilder.construct();


        SvgBuilder.construct();
        IconsIndexBuilder.construct();
        IconsSvgoBuilder.construct();


        LayoutBuilder.builderObj();
        RouterBuilder.builderObj();
        StoreBuilder.builderObj();
        StylesBuilder.builderObj();
        UtilsBuilder.builderObj();

        ViewsBuilder.builderObj();
        AppBuilder.builderObj();
        VueBuilder.builderObj();
//        AssetsBuilder.builderObj();


    }



}
