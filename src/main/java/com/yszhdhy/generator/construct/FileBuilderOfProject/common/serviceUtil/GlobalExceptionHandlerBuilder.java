package com.yszhdhy.generator.construct.FileBuilderOfProject.common.serviceUtil;

import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.utils.FreeMarkerUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandlerBuilder {

    public static void construct() throws IOException {
        Map<String, Object> data = new HashMap<>();
        data.put("packageName",  ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".exception;");
        data.put("packageNameResult",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".result.Result");


        FreeMarkerUtils.parse("GlobalExceptionHandler.ftl",
                data,
                PackagePath.PACKAGE_SERVICE_UTIL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId()+"/exception/GlobalExceptionHandler.java",
                "/service-util");
    }
}
