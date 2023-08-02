package com.yszhdhy.generator.constant.common;

import java.util.Arrays;
import java.util.List;

public enum TemplateFileList {

    BASE_COMMON_UTIL_PACKAGE(Arrays.asList("add-or-update.vue.vm", "Controller.java.vm", "Dao.java.vm",
            "Dao.xml.vm","Entity.java.vm","index.vue.vm","Service.java.vm","ServiceImpl.java.vm",
            "generator.properties","Vue3index.vue.vm")),

    ;


    private List<String> files;


    TemplateFileList(List<String> files) {
        this.files = files;
    }


    public List<String> getFiles() {
        return files;
    }
}
