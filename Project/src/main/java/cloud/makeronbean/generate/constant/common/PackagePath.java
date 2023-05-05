package cloud.makeronbean.generate.constant.common;

import cloud.makeronbean.generate.utils.SystemUtils;

public enum PackagePath {

    PACKAGE_COMMON_PATH(SystemUtils.getProjectPath()+"/common"),  //common 文件夹的路径
    PACKAGE_COMMON_UTIL_PATH(SystemUtils.getProjectPath()+"/common"+"/common-util"), //common-util 文件夹的路径
    ;

    private String packagePath;

    PackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getPackagePath() {
        return packagePath;
    }
}
