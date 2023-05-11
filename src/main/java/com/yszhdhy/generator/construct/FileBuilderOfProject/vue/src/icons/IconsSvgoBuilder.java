package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.icons;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;

public class IconsSvgoBuilder {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("svgo.ftl",
                null,
                SystemUtils.getProjectPath() + "/vue/src/icons/svgo.yml",
                "/vue/src/icons");

    }
}
