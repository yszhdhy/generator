package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.build;

import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class buildBuilder {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("index.ftl",
                null,
                SystemUtils.getProjectPath()+"/vue/build/index.js",
                "/vue/build");
    }
}
