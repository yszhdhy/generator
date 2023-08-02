package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.utils;

import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.FileUtilsVue;
import com.yszhdhy.generator.model.vo.VueFileVo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilsBuilder {



    public static void builderObj() throws IOException {
        List<VueFileVo> vueFileVos = new ArrayList<>();
        vueFileVos.add(new VueFileVo("auth.ftl","auth",null,"/vue/src/utils",".js"));
        vueFileVos.add(new VueFileVo("btn-permission.ftl","btn-permission",null,"/vue/src/utils",".js"));
        vueFileVos.add(new VueFileVo("get-page-title.ftl","get-page-title",null,"/vue/src/utils",".js"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/utils",".js"));
        vueFileVos.add(new VueFileVo("request.ftl","request",null,"/vue/src/utils",".js"));
        vueFileVos.add(new VueFileVo("validate.ftl","validate",null,"/vue/src/utils",".js"));


        FileUtilsVue.construct(vueFileVos);
    }


}
