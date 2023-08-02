package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.views;

import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.FileUtilsVue;
import com.yszhdhy.generator.model.vo.VueFileVo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewsBuilder {



    public static void builderObj() throws IOException {
        List<VueFileVo> vueFileVos = new ArrayList<>();
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/views/dashboard",".vue"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/views/form",".vue"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/views/login",".vue"));

        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/views/system/sysMenu",".vue"));
        vueFileVos.add(new VueFileVo("assignAuth.ftl","assignAuth",null,"/vue/src/views/system/sysRole",".vue"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/views/system/sysRole",".vue"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/views/system/sysUser",".vue"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/views/table",".vue"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/views/tree",".vue"));
        vueFileVos.add(new VueFileVo("404.ftl","404",null,"/vue/src/views",".vue"));


        FileUtilsVue.construct(vueFileVos);
    }


}
