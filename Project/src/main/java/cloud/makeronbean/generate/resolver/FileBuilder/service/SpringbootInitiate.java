package cloud.makeronbean.generate.resolver.FileBuilder.service;

import cloud.makeronbean.generate.constant.code.CodeTemplate;
import cloud.makeronbean.generate.constant.code.Knife4jCodeConst;
import cloud.makeronbean.generate.constant.code.SpringParentCodeConst;
import cloud.makeronbean.generate.constant.common.ModuleGroupId;
import cloud.makeronbean.generate.entity.project.Project;
import cloud.makeronbean.generate.entity.project.ProjectInfo;
import cloud.makeronbean.generate.resolver.FileBuilder.BuildTheFile;
import cloud.makeronbean.generate.utils.MkdirFileWriteUtils;
import cloud.makeronbean.generate.utils.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 对启动类进行构建
 */
public class SpringbootInitiate {

    public static void construct(ProjectInfo info) throws IOException {


        List<CodeTemplate> codeTemplateList = new ArrayList<>(Arrays.asList(SpringParentCodeConst.values()));

        String filePath = info.getBaseGeneratePathForModuleGroupId(SystemUtils.getProjectPath(),
                "/"+new File(SystemUtils.getProjectPath()).getName(), ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId());
       BuildTheFile.construct(codeTemplateList,filePath, ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId());



//        List<CodeTemplate> codeTemplateList = new ArrayList<>(Arrays.asList(SpringParentCodeConst.values()));
//
//        String filePath = info.getBaseGeneratePathForModuleGroupId(SystemUtils.getProjectPath(),
//                null, ModuleGroupId.MODULE_SERVICE_UTIL_CESHI_GROUP_ID.getModuleGroupId());
//        BuildTheFile.construct(codeTemplateList,filePath, ModuleGroupId.MODULE_SERVICE_UTIL_CESHI_GROUP_ID.getModuleGroupId());


    }
}
