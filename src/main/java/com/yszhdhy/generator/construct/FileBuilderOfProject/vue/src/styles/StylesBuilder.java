package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.styles;

import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.FileUtilsVue;
import com.yszhdhy.generator.model.vo.VueFileVo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StylesBuilder {



    public static void builderObj() throws IOException {
        List<VueFileVo> vueFileVos = new ArrayList<>();
        vueFileVos.add(new VueFileVo("element-ui.ftl","element-ui",null,"/vue/src/styles",".scss"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/styles",".scss"));
        vueFileVos.add(new VueFileVo("mixin.ftl","mixin",null,"/vue/src/styles",".scss"));
        vueFileVos.add(new VueFileVo("sidebar.ftl","sidebar",null,"/vue/src/styles",".scss"));
        vueFileVos.add(new VueFileVo("transition.ftl","transition",null,"/vue/src/styles",".scss"));
        vueFileVos.add(new VueFileVo("variables.ftl","variables",null,"/vue/src/styles",".scss"));


        FileUtilsVue.construct(vueFileVos);
    }


}
