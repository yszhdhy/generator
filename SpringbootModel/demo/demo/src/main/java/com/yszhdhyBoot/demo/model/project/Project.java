package com.yszhdhyBoot.demo.model.project;


import com.yszhdhyBoot.demo.constant.common.ModuleGroupId;
import com.yszhdhyBoot.demo.construct.FileBuilderOfProject.BuildTheFile;
import com.yszhdhyBoot.demo.construct.ItemMovement;
import com.yszhdhyBoot.demo.construct.structure.Model.Builder;
import com.yszhdhyBoot.demo.construct.structure.common.BuilderOfCommon;
import com.yszhdhyBoot.demo.utils.*;
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

    private static final List<String> BASE_PACKAGE = Arrays.asList("controller", "mapper", "service");

    public Project() throws DocumentException, FileNotFoundException {
        PomUtils.init("pom.xml");
        info = new ProjectInfo(SystemUtils.getProjectPath(), PomUtils.getSingleValue("groupId"));
    }

    public void generate() {
        try {
            // 创建基本目录
            for (String s : BASE_PACKAGE) {
//                执行本目录
                FileUtils.mkdir(info.getBaseGeneratePathForModuleGroupId(SystemUtils.getProjectPath(),
                        null,
                        ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()), s);
            }



            // 刷新pom文件

            //项目移动
            ItemMovement.construct();


            // 构建Model 模块
            Builder.construct(new Project().getInfo(),SystemUtils.getProjectPath(),"/model");

            //构建 common 模块
            BuilderOfCommon.construct(info,SystemUtils.getProjectPath(),"/common");

            //再次删除 src
//            DeleteFile.deleteFile();
            //项目移动
//            ItemMovement.construct();

            // 生成配置文件
            FileUtils.touch(SystemUtils.getProjectPath()+"/"+new File(SystemUtils.getProjectPath()).getName()+"/" + "src" + "/" + "main" + "/" + "resources" + "/" + "application.yaml");


            //构建文件
            BuildTheFile.buildTheFile(info);


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
