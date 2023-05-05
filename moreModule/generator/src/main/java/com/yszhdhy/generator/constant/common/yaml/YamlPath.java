package com.yszhdhy.generator.constant.common.yaml;

import com.yszhdhy.generator.utils.SystemUtils;

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
