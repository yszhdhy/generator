package com.yszhdhy.generator.model;


import com.yszhdhy.generator.constant.code.CodeTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author makeronbean
 * @createDate 2023-05-01  19:06
 * @description
 */

public class BaseStarterAdapter extends BaseStarter{
    @Override
    protected List<Dependency> getDefaultDependencies() {
        return null;
    }

    @Override
    protected Map<String, Object> getDefaultYamlMap() {
        return null;
    }

    @Override
    protected List<CodeTemplate> getDefaultCodeTemplateList() {
        return null;
    }
}
