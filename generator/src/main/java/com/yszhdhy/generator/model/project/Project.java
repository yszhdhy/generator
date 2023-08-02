package com.yszhdhy.generator.model.project;


import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.construct.FileBuilderOfProject.BuildTheFile;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.commonElasticsearch.ElasticsearchModelFileBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.commonMinio.MinioModelFileBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.security.SecurityModelFileBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue3.Vue3ModelFileBuilder;
import com.yszhdhy.generator.construct.ItemMovement;
import com.yszhdhy.generator.construct.structure.Model.Builder;
import com.yszhdhy.generator.construct.structure.common.BuilderOfCommon;
import com.yszhdhy.generator.construct.structure.common.commonElasticsearch.BuilderOfElasticsearch;
import com.yszhdhy.generator.construct.structure.common.commonMinio.BuilderOfMinio;
import com.yszhdhy.generator.construct.structure.common.commonSecurity.BuilderOfSecurity;
import com.yszhdhy.generator.construct.structure.database.BuilderSql;
import com.yszhdhy.generator.construct.structure.generatorCRUD.BuilderOfGeneratorCRUD;
import com.yszhdhy.generator.construct.structure.vue.BuilderOfVue;
import com.yszhdhy.generator.construct.structure.vue3.BuilderOfVue3;
import com.yszhdhy.generator.model.vo.PackageVo;
import com.yszhdhy.generator.utils.*;
import org.dom4j.DocumentException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Project {
    private final ProjectInfo info;

    public ProjectInfo getInfo() {
        return info;
    }

    private static final List<PackageVo> BASE_PACKAGE = Arrays.asList(new PackageVo("controller", null),
            new PackageVo("mapper", Arrays.asList(new PackageVo("xml", null))),
            new PackageVo("service", Arrays.asList(new PackageVo("impl", null))),
            new PackageVo("utils", null));

    public Project() throws DocumentException, FileNotFoundException {

        PomUtils.init("pom.xml");
        System.out.println("文件已经欧克了");
        info = new ProjectInfo(SystemUtils.getProjectPath(), PomUtils.getSingleValue("groupId"));

    }

    /**
     * @author CaptureOrNew
     * @description 生成基本框架 （后端和数据库）
     * @date 15:47:04 2023/7/22
     * @param dbUrl
     * @param port
     * @param userName
     * @param dbPassword
     * @param dbName
     **/
    public void generate(String dbUrl, String port, String userName, String dbPassword, String dbName) {
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
            Builder.construct(new Project().getInfo(), SystemUtils.getProjectPath(), "/model");

            //构建 common 模块
            BuilderOfCommon.construct(info, SystemUtils.getProjectPath(), "/common");

            //构建vue 模块
//            BuilderOfVue.construct();

            //构建CRUD生成器
            BuilderOfGeneratorCRUD.construct();

            //重新指定service的pom文件
            PomUtils.init(SystemUtils.getProjectPath() + "/" + new File(SystemUtils.getProjectPath()).getName() + "/pom.xml");

            //构建文件
            BuildTheFile.buildTheFile(info);

            //构建数据库
            BuilderSql.construct(dbUrl, port, userName, dbPassword, dbName);

            //再次删除 src
            DeleteFile.deleteFile();


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }


    /**
     * @author CaptureOrNew
     * @description 构建vue2前端模板
     * @date 15:45:21 2023/7/22
     **/
    public void generateVue2() throws DocumentException, IOException {
        //构建vue 模块
        BuilderOfVue.construct();
        BuildTheFile.vue(); //构建文件
    }

    /**
     * @author CaptureOrNew
     * @description 构建vue2前端模板
     * @date 15:45:21 2023/7/22
     **/
    public void generateVue3() throws DocumentException, IOException {
        //构建vue 模块
        BuilderOfVue3.construct();
        //构建文件
        Vue3ModelFileBuilder.construct();
    }

    /**
     * @author CaptureOrNew
     * @description 构建后端security模块
     * @date 15:45:42 2023/7/22
     * @param info
     **/
    public void generateSecurity(ProjectInfo info) throws DocumentException, IOException {

        //构建Security 模块
        BuilderOfSecurity.BuilderSecurity(info);
        //构建文件
        SecurityModelFileBuilder.construct();
    }


    public void generateMinio(ProjectInfo info) throws DocumentException, IOException {
        // 构建minio模块
        BuilderOfMinio.BuilderMinio(info);
        //构建文件
        MinioModelFileBuilder.construct();
    }

    public void generateElasticsearch(ProjectInfo info) throws DocumentException, IOException {
        // 构建Elasticsearch模块
        BuilderOfElasticsearch.BuilderElasticsearch(info);
        //构建文件
        ElasticsearchModelFileBuilder.construct();
    }
}
