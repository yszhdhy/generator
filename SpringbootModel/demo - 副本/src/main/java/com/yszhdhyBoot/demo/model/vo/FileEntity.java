package com.yszhdhyBoot.demo.model.vo;

import com.yszhdhyBoot.demo.constant.code.CodeTemplate;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public  class FileEntity {

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


}
