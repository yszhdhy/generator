package com.yszhdhyBoot.demo.construct.FileBuilderOfProject.service.yaml;

import com.yszhdhyBoot.demo.utils.YamlDisposition;

import java.io.IOException;
import java.util.*;

public class YamlInitiate {

    public static void construct(String pomPath,Map<String, Object> yamlMap) throws IOException {

        YamlDisposition.construct(pomPath,yamlMap);
    }

    /**
     * 组装yaml
     * @param yamlMap1
     * @param yamlMap2
     * @return
     */
    public static Map<String, Object> assemble(Map<String, Object> yamlMap1, Map<String, Object> yamlMap2){

        for (String key : yamlMap2.keySet()) {
            yamlMap1.put(key,yamlMap2.get(key));
        }

        return yamlMap1;
    }
}
