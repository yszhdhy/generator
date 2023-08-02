package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src;

import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.FileUtilsVue;
import com.yszhdhy.generator.model.vo.VueFileVo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppBuilder {

    public static void builderObj() throws IOException {
        List<VueFileVo> vueFileVos = new ArrayList<>();
        vueFileVos.add(new VueFileVo("App.ftl","App",null,"/vue/src",".vue"));
        vueFileVos.add(new VueFileVo("main.ftl","main",null,"/vue/src",".js"));
        vueFileVos.add(new VueFileVo("permission.ftl","permission",null,"/vue/src",".js"));
        vueFileVos.add(new VueFileVo("settings.ftl","settings",null,"/vue/src",".js"));


        FileUtilsVue.construct(vueFileVos);
    }
}
