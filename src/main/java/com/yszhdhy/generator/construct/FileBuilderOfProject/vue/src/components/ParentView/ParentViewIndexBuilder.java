package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.components.ParentView;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;

public class ParentViewIndexBuilder {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("index.ftl",
                null,
                SystemUtils.getProjectPath()+"/vue/src/components/ParentView/index.vue",
                "/vue/src/components/ParentView");
    }
}
