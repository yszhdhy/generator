package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.components.Breadcrumb;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;

public class BreadcrumbIndexBuilder {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("index.ftl",
                null,
                SystemUtils.getProjectPath()+"/vue/src/components/Breadcrumb/index.vue",
                "/vue/src/components/Breadcrumb");
    }
}
