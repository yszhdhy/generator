package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.components.SvgIcon;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;

public class SvgIconIndexBuilder {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("index.ftl",
                null,
                SystemUtils.getProjectPath()+"/vue/src/components/SvgIcon/index.vue",
                "/vue/src/components/SvgIcon");
    }
}
