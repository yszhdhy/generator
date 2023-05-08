package com.yszhdhy.generator.construct.FileBuilderOfProject.common.serviceUtil;


import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.utils.FreeMarkerUtils;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Knife4jConfigBuilder {

    public static void construct() throws IOException {
        Map<String, Object> data = new HashMap<>();
        data.put("packageName",  ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".knife4j;");
        data.put("path", "\"/admin/.*\"");

        FreeMarkerUtils.parse("Knife4jConfig.ftl",
                data,
                PackagePath.PACKAGE_SERVICE_UTIL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId()+"/knife4j/Knife4jConfig.java",
                "/service-util");
    }
}
