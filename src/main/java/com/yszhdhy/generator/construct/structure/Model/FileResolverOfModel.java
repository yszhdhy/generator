package com.yszhdhy.generator.construct.structure.Model;


import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.model.project.ProjectInfo;
import com.yszhdhy.generator.utils.FileUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author yszhdhy
 * @createDate 2023-05-01  16:56
 * @description
 * Model 模块
 */

public class FileResolverOfModel {

    private static final List<String> BASE_PACKAGE = Arrays.asList( "vo", "to", "dto");


    public static void construct(ProjectInfo info, String basePath, String ModulePath){


        File file1 = new File(SystemUtils.getProjectPath(),"model");
        file1.mkdir();

//        项目路径
        String pathForModule = info.getBaseGeneratePathForModuleGroupId(basePath, ModulePath,
                ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId());


        for (String file : BASE_PACKAGE) {
//            项目路劲+ 包路径
            FileUtils.mkdir(pathForModule, "/"+file);
        }

    }
}
