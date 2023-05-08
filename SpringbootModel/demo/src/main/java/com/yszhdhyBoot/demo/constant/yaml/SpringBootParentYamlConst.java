package com.yszhdhyBoot.demo.constant.yaml;


import com.yszhdhyBoot.demo.utils.PomUtils;

@SuppressWarnings("all")
public enum SpringBootParentYamlConst implements YamlTemplate {
    SERVER_PORT("server.port", 8080),

    APP_NAME("spring.application.name", PomUtils.getSingleValue("artifactId")),

    ;

    SpringBootParentYamlConst(String key, Object defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    private final String key;
    private final Object defaultValue;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public Object getDefaultValue() {
        return defaultValue;
    }

}
