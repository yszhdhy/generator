package com.yszhdhy.generator.construct.FileBuilderOfProject.service;



import com.yszhdhy.generator.constant.code.CodeTemplate;
import com.yszhdhy.generator.constant.code.SpringParentCodeConst;
import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.construct.FileBuilderOfProject.BuildTheFile;
import com.yszhdhy.generator.model.project.ProjectInfo;
import com.yszhdhy.generator.utils.SystemUtils;

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



    }
}
