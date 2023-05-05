package com.yszhdhy.generator.constant.common;

public enum ModulePath {

    MODULE_COMMON_UTIL_PATH("/common-util"),
    MODULE_SERVICE_UTIL_PATH("/service-util"),
    ;

    private String modulePath;

    ModulePath(String modulePath) {
        this.modulePath = modulePath;
    }

    public String getModulePath() {
        return modulePath;
    }

}
