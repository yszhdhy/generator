package com.yszhdhy.generator.construct.FileBuilderOfProject.service.generatorCRUD.utils;

import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.utils.FreeMarkerUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OtherUtilsBuilder {

    public static void construct() throws IOException {

        Map<String, Object> data = new HashMap<>();
        data.put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD.utils");

        String[] files = {"DateUtils.ftl","R.ftl","RRException.ftl","RRExceptionHandler.ftl"};

        for (String file : files) {
            FreeMarkerUtils.parse(file,
                    data,
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/generatorCRUD/utils/"+file.replaceAll(".ftl",".java"),
                    "/generatorCRUD/utils");
        }


    }
}
