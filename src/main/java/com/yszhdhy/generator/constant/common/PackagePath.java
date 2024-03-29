package com.yszhdhy.generator.constant.common;


import com.yszhdhy.generator.utils.SystemUtils;

import java.io.File;

public enum PackagePath {

    PACKAGE_COMMON_PATH(SystemUtils.getProjectPath()+"/common"),  //common 文件夹的路径
    PACKAGE_COMMON_UTIL_PATH(SystemUtils.getProjectPath()+"/common"+"/common-util"), //common-util 文件夹的路径
    PACKAGE_SERVICE_UTIL_PATH(SystemUtils.getProjectPath()+"/common"+ "/service-util"), //service-util 文件夹的路径

    PACKAGE_COMMON_SECURITY_PATH(SystemUtils.getProjectPath()+"/common"+ "/common-security"), //common-security 文件夹的路径
    PACKAGE_COMMON_MINIO_PATH(SystemUtils.getProjectPath()+"/common"+ "/common-minio"), //common-minio 文件夹的路径
    PACKAGE_COMMON_ELASTICSEARCH_PATH(SystemUtils.getProjectPath()+"/common"+ "/common-elasticsearch"), //common-elasticsearch 文件夹的路径

    PACKAGE_MODEL_PATH(SystemUtils.getProjectPath()+"/model"), //model 文件夹的路径

    PACKAGE_SERVICE_PATH(SystemUtils.getProjectPath()+"/"+new File(SystemUtils.getProjectPath()).getName()), //service 文件夹的路径
    ;

    private String packagePath;

    PackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getPackagePath() {
        return packagePath;
    }
}
