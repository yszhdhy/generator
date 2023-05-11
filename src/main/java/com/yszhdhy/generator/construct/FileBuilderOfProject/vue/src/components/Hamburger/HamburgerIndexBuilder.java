package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.components.Hamburger;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;

public class HamburgerIndexBuilder {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("index.ftl",
                null,
                SystemUtils.getProjectPath()+"/vue/src/components/Hamburger/index.vue",
                "/vue/src/components/Hamburger");
    }
}
