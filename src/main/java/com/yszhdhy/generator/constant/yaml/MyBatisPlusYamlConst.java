package com.yszhdhy.generator.constant.yaml;

import com.yszhdhy.generator.utils.PomUtils;


@SuppressWarnings("all")
public enum MyBatisPlusYamlConst implements YamlTemplate {
    USERNAME("spring.datasource.username", "root"),
    PASSWORD("spring.datasource.password", "123456"),
    DRIVER_CLASS_NAME("spring.datasource.driver-class-name", "com.mysql.cj.jdbc.Driver"),
    URL("spring.datasource.url","jdbc:mysql://localhost:3306/dbName?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai"),
    LOG("mybatis-plus.configuration.log-impl", "org.apache.ibatis.logging.stdout.StdOutImpl"),
    UNDERSCORE_2_CAMEL("mybatis-plus.configuration.map-underscore-to-camel-case", true),
    TYPE_ALIASES_PACKAGE("mybatis-plus.type-aliases-package",  PomUtils.getSingleValue("groupId") + ".entity"),
    LOGIC_DELETE_FIELD("mybatis-plus.global-config.db-config.logic-delete-field", "isDelete"),
    LOGIC_DELETE_VALUE("mybatis-plus.global-config.db-config.logic-delete-value", 1),
    LOGIC_NOT_DELETE_VALUE("mybatis-plus.global-config.db-config.logic-not-delete-value", 0),
    ;

    MyBatisPlusYamlConst(String key, Object defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    private final String key;
    private final Object defaultValue;

    public void setDefaultValue(String defaultValue){
        defaultValue = defaultValue;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public Object getDefaultValue() {
        return defaultValue;
    }
}
