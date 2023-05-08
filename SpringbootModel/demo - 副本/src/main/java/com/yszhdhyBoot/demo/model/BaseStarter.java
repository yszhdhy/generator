package com.yszhdhyBoot.demo.model;

import com.yszhdhyBoot.demo.constant.code.CodeTemplate;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author makeronbean
 * @createDate 2023-05-01  08:40
 * @description 依赖基类
 */
@Data
public abstract class BaseStarter {

    /**
     * 依赖列表
     */
    List<Dependency> dependencyList;



    /**
     * yaml中的map
     */
    protected Map<String, Object> yamlMap;

    /**
     * 代码片段
     */
    protected List<CodeTemplate> codeTemplateList;

    /**
     * 加载顺序
     */
    protected Integer order;


    /**
     * 依赖信息
     */
    @Data
    public static class Dependency {
        /**
         * groupId
         */
        protected String groupId;

        /**
         * artifactId
         */
        protected String artifactId;

        /**
         * version
         */
        protected String version;

        /**
         * scope
         */
        protected String scope;

        /**
         * optional
         */
        protected String optional;

        /**
         * 标签名称
         */
        protected String tabName;

        /**
         * 父节点名称
         */
        protected String parentNodeName;
    }

    protected abstract List<Dependency> getDefaultDependencies();
    protected abstract Map<String, Object> getDefaultYamlMap();
    protected abstract List<CodeTemplate> getDefaultCodeTemplateList();

}
