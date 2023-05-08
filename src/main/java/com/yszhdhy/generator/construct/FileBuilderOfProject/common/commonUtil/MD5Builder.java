package com.yszhdhy.generator.construct.FileBuilderOfProject.common.commonUtil;

import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.utils.FreeMarkerUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MD5Builder {

    public static void construct() throws IOException {
        Map<String, Object> data = new HashMap<>();
        data.put("packageName",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".utils;");

        FreeMarkerUtils.parse("MD5.ftl",
                data,
                PackagePath.PACKAGE_COMMON_UTIL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId()+"/utils/MD5.java",
                "/common-util");
    }
}
