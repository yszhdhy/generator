package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.api.system;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;

public class SysRoleBuilderVue {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("sysRole.ftl",
                null,
                SystemUtils.getProjectPath()+"/vue/src/api/system/sysRole.js",
                "/vue/src/api/system");
    }
}
