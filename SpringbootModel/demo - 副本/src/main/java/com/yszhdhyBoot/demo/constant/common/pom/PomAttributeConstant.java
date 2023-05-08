package com.yszhdhyBoot.demo.constant.common.pom;

public enum PomAttributeConstant {

    POM_ATTRIBUTE_VERSION("2.3.6.RELEASE"),
    ;

    private String pomAttribute;

    PomAttributeConstant(String pomAttribute) {
        this.pomAttribute = pomAttribute;
    }

    public String getPomAttribute() {
        return pomAttribute;
    }

}
