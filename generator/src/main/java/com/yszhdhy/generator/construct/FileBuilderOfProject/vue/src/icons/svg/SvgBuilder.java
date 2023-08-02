package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.icons.svg;

import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SvgBuilder {
    public static void construct() throws IOException {

        List<String> list = Arrays.asList("dashboard.ftl", "example.ftl",
                "eye.ftl", "eye-open.ftl", "form.ftl", "link.ftl", "nested.ftl", "password.ftl", "table.ftl",
                "tree.ftl","user.ftl");

        for (String file : list) {
            FreeMarkerUtils.parse(file,
                    null,
                    SystemUtils.getProjectPath()+"/vue/src/icons/svg/"+file.split("\\.")[0]+".svg",
                    "/vue/src/icons/svg");
        }

    }
}
