package com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.layout;

import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.FileUtilsVue;
import com.yszhdhy.generator.model.vo.VueFileVo;
import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LayoutBuilder {



    public static void builderObj() throws IOException {
        List<VueFileVo> vueFileVos = new ArrayList<>();
        vueFileVos.add(new VueFileVo("FixiOSBug.ftl","FixiOSBug",null,"/vue/src/layout/components/Sidebar",".js"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/layout/components/Sidebar",".vue"));
        vueFileVos.add(new VueFileVo("Item.ftl","Item",null,"/vue/src/layout/components/Sidebar",".vue"));
        vueFileVos.add(new VueFileVo("Link.ftl","Link",null,"/vue/src/layout/components/Sidebar",".vue"));
        vueFileVos.add(new VueFileVo("Logo.ftl","Logo",null,"/vue/src/layout/components/Sidebar",".vue"));
        vueFileVos.add(new VueFileVo("SidebarItem.ftl","SidebarItem",null,"/vue/src/layout/components/Sidebar",".vue"));

        vueFileVos.add(new VueFileVo("AppMain.ftl","AppMain",null,"/vue/src/layout/components",".vue"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/layout/components",".js"));
        vueFileVos.add(new VueFileVo("Navbar.ftl","Navbar",null,"/vue/src/layout/components",".vue"));

        vueFileVos.add(new VueFileVo("ResizeHandler.ftl","ResizeHandler",null,"/vue/src/layout/mixin",".js"));
        vueFileVos.add(new VueFileVo("index.ftl","index",null,"/vue/src/layout",".vue"));
        FileUtilsVue.construct(vueFileVos);
    }


}
