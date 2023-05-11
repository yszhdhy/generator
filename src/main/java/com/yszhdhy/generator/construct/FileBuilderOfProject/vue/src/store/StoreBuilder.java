package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.store;

import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.FileUtilsVue;
import com.yszhdhy.generator.model.vo.VueFileVo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreBuilder {



    public static void builderObj() throws IOException {
        List<VueFileVo> vueFileVos = new ArrayList<>();
        vueFileVos.add(new VueFileVo("app.ftl","app",null,"/vue/src/store/modules",".js"));
        vueFileVos.add(new VueFileVo("settings.ftl","settings",null,"/vue/src/store/modules",".js"));
        vueFileVos.add(new VueFileVo("user.ftl","user",null,"/vue/src/store/modules",".js"));
        vueFileVos.add(new VueFileVo("getters.ftl","getters",null,"/vue/src/store",".js"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/store",".js"));

        FileUtilsVue.construct(vueFileVos);
    }


}
