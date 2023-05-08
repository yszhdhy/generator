package com.yszhdhyBoot.demo.constant.common.yaml;

import com.yszhdhyBoot.demo.utils.SystemUtils;

import java.io.File;

public enum YamlPath {

    YAML_PATH(SystemUtils.getProjectPath()+"/"+new File(SystemUtils.getProjectPath()).getName()+ "/src/main/resources/application.yaml"),
    ;

    private String yamlPath;

    YamlPath(String yamlPath) {
        this.yamlPath = yamlPath;
    }

    public String getYamlPath() {
        return yamlPath;
    }

}
