package com.yszhdhy.generator.construct.FileBuilderOfProject.service.mapper;

import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.utils.FreeMarkerUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SysUserMapperBuilder {
    public static void construct() throws IOException {

        Map<String, Object> data = new HashMap<>();
        data.put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mapper");
        data.put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));

        FreeMarkerUtils.parse("SysUserMapper.ftl",
                data,
                PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/mapper/SysUserMapper.java",
                "/service/mapper");
    }
}
