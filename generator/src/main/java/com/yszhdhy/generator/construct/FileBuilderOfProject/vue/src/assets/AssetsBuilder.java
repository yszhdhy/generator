package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.assets;

import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.FileUtilsVue;
import com.yszhdhy.generator.model.vo.VueFileVo;
import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssetsBuilder {
    public static void builderObj() throws IOException {
        List<VueFileVo> vueFileVos = new ArrayList<>();
        vueFileVos.add(new VueFileVo("404.ftl","404",null,"/vue/src/assets/404_images",".png"));
        vueFileVos.add(new VueFileVo("404_cloud.ftl","404_cloud",null,"/vue/src/assets/404_images",".png"));

        FileUtilsVue.construct(vueFileVos);

    }
}
