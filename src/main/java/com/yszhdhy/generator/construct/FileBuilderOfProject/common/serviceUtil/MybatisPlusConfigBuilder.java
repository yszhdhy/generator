package com.yszhdhy.generator.construct.FileBuilderOfProject.common.serviceUtil;


import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.utils.FreeMarkerUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MybatisPlusConfigBuilder {

    public static void construct() throws IOException {
        Map<String, Object> data = new HashMap<>();
        data.put("packageName",  ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mp;");
        data.put("basePackages","\"" + ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mapper\"");

        FreeMarkerUtils.parse("MybatisPlusConfig.ftl",
                data,
                PackagePath.PACKAGE_SERVICE_UTIL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId()+"/mp/MybatisPlusConfig.java",
                "/service-util");
    }
}
