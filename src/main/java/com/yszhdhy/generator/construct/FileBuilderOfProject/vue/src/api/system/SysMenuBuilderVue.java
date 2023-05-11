package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.api.system;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;

public class SysMenuBuilderVue {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("sysMenu.ftl",
                null,
                SystemUtils.getProjectPath()+"/vue/src/api/system/sysMenu.js",
                "/vue/src/api/system");
    }
}
