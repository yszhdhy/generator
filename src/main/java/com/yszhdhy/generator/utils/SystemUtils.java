package com.yszhdhy.generator.utils;

/**
 * @author makeronbean
 * @createDate 2023-05-01  09:47
 * @description
 */

public class SystemUtils {
    /**
     * 获取项目路径
     * @return 项目路径
     */
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }
}
