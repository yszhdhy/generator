package com.yszhdhy.generator.constant.common;

public enum ModulePath {

    MODULE_COMMON_UTIL_PATH("/common-util"),
    MODULE_SERVICE_UTIL_PATH("/service-util"),
    MODULE_COMMON_SECURITY_PATH("/common-security"),
    MODULE_COMMON_MINIO_PATH("/common-minio"),
    MODULE_COMMON_ELASTICSEARCH_PATH("/common-elasticsearch"),
    MODULE_MODEL_PATH("/model"),
    ;

    private String modulePath;

    ModulePath(String modulePath) {
        this.modulePath = modulePath;
    }

    public String getModulePath() {
        return modulePath;
    }

}
