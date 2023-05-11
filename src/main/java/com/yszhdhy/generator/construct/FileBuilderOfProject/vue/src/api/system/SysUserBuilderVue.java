package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.api.system;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;

public class SysUserBuilderVue {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("sysUser.ftl",
                null,
                SystemUtils.getProjectPath()+"/vue/src/api/system/sysUser.js",
                "/vue/src/api/system");
    }
}
