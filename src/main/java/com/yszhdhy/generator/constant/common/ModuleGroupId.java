package com.yszhdhy.generator.constant.common;

public enum ModuleGroupId {

    MODULE_SERVICE_GROUP_ID("com/xc/example"), //service项目
    MODULE_MODEL_GROUP_ID("com/xc/model"), //model项目
    MODULE_COMMON_UTIL_GROUP_ID("com/xc/common"), //common项目
    MODULE_SERVICE_UTIL_GROUP_ID("com/xc/common"), //common项目
    MODULE_SERVICE_UTIL_CESHI_GROUP_ID("com/yszhdhy/generator"), //common项目
    ;



    private String moduleGroupId;

    ModuleGroupId(String moduleGroupId) {
        this.moduleGroupId = moduleGroupId;
    }

    public String getModuleGroupId() {
        return moduleGroupId;
    }
}
