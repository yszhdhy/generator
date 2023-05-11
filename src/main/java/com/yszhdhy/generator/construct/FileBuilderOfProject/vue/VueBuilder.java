package com.yszhdhy.generator.construct.FileBuilderOfProject.vue;

import com.yszhdhy.generator.model.vo.VueFileVo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VueBuilder {


    public static void builderObj() throws IOException {
        List<VueFileVo> vueFileVos = new ArrayList<>();
        vueFileVos.add(new VueFileVo(".env.ftl",".env",null,"/vue",".development"));
        vueFileVos.add(new VueFileVo(".env2.ftl",".env",null,"/vue",".production"));
        vueFileVos.add(new VueFileVo(".env3.ftl",".env",null,"/vue",".staging"));
        vueFileVos.add(new VueFileVo(".eslintrc.ftl",".eslintrc",null,"/vue",".js"));
        vueFileVos.add(new VueFileVo("es.ftl",".eslintignore",null,"/vue",""));
        vueFileVos.add(new VueFileVo(".ftl",".editorconfig",null,"/vue",""));
        vueFileVos.add(new VueFileVo(".travis.ftl",".travis",null,"/vue",".yml"));
        vueFileVos.add(new VueFileVo("babel.config.ftl","babel.config",null,"/vue",".js"));
        vueFileVos.add(new VueFileVo("git.ftl",".gitignore",null,"/vue",""));
        vueFileVos.add(new VueFileVo("jsconfig.ftl","jsconfig",null,"/vue",".json"));
        vueFileVos.add(new VueFileVo("jest.config.ftl","jest.config",null,"/vue",".js"));
        vueFileVos.add(new VueFileVo("package.ftl","package",null,"/vue",".json"));
        vueFileVos.add(new VueFileVo("package-lock.ftl","package-lock",null,"/vue",".json"));
        vueFileVos.add(new VueFileVo("postcss.config.ftl","postcss.config",null,"/vue",".js"));
        vueFileVos.add(new VueFileVo("vue.config.ftl","vue.config",null,"/vue",".js"));

        FileUtilsVue.construct(vueFileVos);
    }
}
