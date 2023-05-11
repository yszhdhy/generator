package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.api;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;

public class TableBuilder {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("table.ftl",
                null,
                SystemUtils.getProjectPath()+"/vue/src/api/table.js",
                "/vue/src/api");
    }
}
