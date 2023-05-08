package com.yszhdhyBoot.demo.model.vo;

import lombok.Data;

@Data
public class Dependency {

    /**
     * groupId
     */
    private String groupId;

    /**
     * artifactId
     */
    private String artifactId;

    /**
     * version
     */
    private String version;

    /**
     * scope
     */
    private String scope;

    /**
     * optional
     */
    private String optional;

    /**
     * 标签名称
     */
    private String tabName;

    /**
     * 父节点名称
     */
    private String parentNodeName;
}
