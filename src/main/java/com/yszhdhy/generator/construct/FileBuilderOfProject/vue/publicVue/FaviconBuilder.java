package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.publicVue;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;

public class FaviconBuilder {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("favicon.ftl",
                null,
                SystemUtils.getProjectPath()+"/vue/public/favicon.ico",
                "/vue/public");
    }
}
