package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.icons;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class IconsIndexBuilder {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("index.ftl",
                null,
                SystemUtils.getProjectPath() + "/vue/src/icons/index.js",
                "/vue/src/icons");

    }
}
