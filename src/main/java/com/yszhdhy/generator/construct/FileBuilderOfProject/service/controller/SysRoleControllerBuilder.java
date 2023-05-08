package com.yszhdhy.generator.construct.FileBuilderOfProject.service.controller;

import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.utils.FreeMarkerUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SysRoleControllerBuilder {
    public static void construct() throws IOException {
        Map<String, Object> data = new HashMap<>();
        data.put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".controller");
        data.put("packageNameService",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
        data.put("packageNameCommon",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
        data.put("packageNameCommonService",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
        data.put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));

        FreeMarkerUtils.parse("SysRoleController.ftl",
                data,
                PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/controller/SysRoleController.java",
                "/service/controller");
    }
}
