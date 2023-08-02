package com.yszhdhy.generator.model.vo;

import com.yszhdhy.generator.constant.code.CodeTemplate;

import com.yszhdhy.generator.model.BaseStarter;
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
