package com.yszhdhy.generator.construct.FileBuilderOfProject.model.system;

import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.utils.FreeMarkerUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SysLoginLogBuilder {
    public static void construct() throws IOException {
        Map<String, Object> data = new HashMap<>();
        data.put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".model");

        FreeMarkerUtils.parse("SysLoginLog.ftl",
                data,
                PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/model/SysLoginLog.java",
                "/model/model/system");
    }
}
