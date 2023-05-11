package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.api;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;

public class UserBuilder {
    public static void construct() throws IOException {


        FreeMarkerUtils.parse("user.ftl",
                null,
                SystemUtils.getProjectPath()+"/vue/src/api/user.js",
                "/vue/src/api");
    }
}
