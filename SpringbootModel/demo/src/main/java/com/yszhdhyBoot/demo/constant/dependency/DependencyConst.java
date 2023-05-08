package com.yszhdhyBoot.demo.constant.dependency;

/**
 * @author makeronbean
 * @createDate 2023-05-01  11:01
 * @description 依赖常量类
 */
@SuppressWarnings("all")
public enum DependencyConst {

    PROJECT("project"),

    MODULE("module"),

    PARENT("parent"),

    DEPENDENCIES("dependencies"),

    DEPENDENCY("dependency"),

    GROUPID("groupId"),

    ARTIFACTID("artifactId"),

    VERSION("version"),

    SCOPE("scope"),

    OPTIONAL("optional"),

    ;

    private final String tabName;

    DependencyConst(String tabName) {
        this.tabName = tabName;
    }

    public String getTabName() {
        return tabName;
    }
}
