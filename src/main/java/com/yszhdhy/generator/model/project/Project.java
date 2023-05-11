package com.yszhdhy.generator.model.project;


import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackageList;
import com.yszhdhy.generator.construct.FileBuilderOfProject.BuildTheFile;
import com.yszhdhy.generator.construct.ItemMovement;
import com.yszhdhy.generator.construct.structure.Model.Builder;
import com.yszhdhy.generator.construct.structure.common.BuilderOfCommon;
import com.yszhdhy.generator.construct.structure.database.BuilderSql;
import com.yszhdhy.generator.construct.structure.vue.BuilderOfVue;
import com.yszhdhy.generator.model.vo.PackageVo;
import com.yszhdhy.generator.utils.*;
import org.dom4j.DocumentException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * @author makeronbean
 * @createDate 2023-05-01  08:28
 * @description 项目类
 */

public class Project {
    private final ProjectInfo info;
    public ProjectInfo getInfo(){
        return info;
    }

//    private static final List<String> BASE_PACKAGE = Arrays.asList("controller", "mapper", "service");
    private static final List<PackageVo> BASE_PACKAGE = Arrays.asList(new PackageVo("controller",null),
            new PackageVo( "mapper",Arrays.asList(new PackageVo("xml",null))),
            new PackageVo("service",Arrays.asList(new PackageVo("impl",null))),
        new PackageVo("utils",null));

    public Project() throws DocumentException, FileNotFoundException {
        PomUtils.init("pom.xml");
        info = new ProjectInfo(SystemUtils.getProjectPath(), PomUtils.getSingleValue("groupId"));
    }

    public void generate(String dbUrl,String port, String userName, String dbPassword, String dbName) {
        try {



            // 创建基本目录
            for (PackageVo packageVo : BASE_PACKAGE) {
//                执行本目录
                FileUtils.mkdir(info.getBaseGeneratePathForModuleGroupId(SystemUtils.getProjectPath(),
                        null,
                        ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()), packageVo);
            }

            // 生成配置文件
            FileUtils.touch(info.getYamlPath());



            // 刷新pom文件

            //项目移动
            ItemMovement.construct();


            // 构建Model 模块
            Builder.construct(new Project().getInfo(),SystemUtils.getProjectPath(),"/model");

            //构建 common 模块
            BuilderOfCommon.construct(info,SystemUtils.getProjectPath(),"/common");

            //构建vue 模块
            BuilderOfVue.construct();

            //重新指定service的pom文件
            PomUtils.init(SystemUtils.getProjectPath()+"/"+new File(SystemUtils.getProjectPath()).getName() +"/pom.xml");
            //构建文件
            BuildTheFile.buildTheFile(info);

            //构建数据库
            BuilderSql.construct(dbUrl,port,userName,dbPassword,dbName);

            //再次删除 src
            DeleteFile.deleteFile();


            System.out.println("heoll");


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
