package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.publicVue;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;

public class IndexBuilder {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("index.ftl",
                null,
                SystemUtils.getProjectPath()+"/vue/public/index.html",
                "/vue/public");
    }
}
