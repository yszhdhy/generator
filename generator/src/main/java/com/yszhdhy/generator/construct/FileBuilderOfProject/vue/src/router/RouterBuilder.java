package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.router;

import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.FileUtilsVue;
import com.yszhdhy.generator.model.vo.VueFileVo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RouterBuilder {



    public static void builderObj() throws IOException {
        List<VueFileVo> vueFileVos = new ArrayList<>();
        vueFileVos.add(new VueFileVo("_import_development.ftl","_import_development",null,"/vue/src/router",".js"));
        vueFileVos.add(new VueFileVo("_import_production.ftl","_import_production",null,"/vue/src/router",".js"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/router",".js"));

        FileUtilsVue.construct(vueFileVos);
    }


}
