package cloud.makeronbean.generate.constant.common;

import java.util.List;

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
