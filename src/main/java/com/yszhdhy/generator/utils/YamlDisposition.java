package com.yszhdhy.generator.utils;


import com.yszhdhy.generator.constant.yaml.MyBatisPlusYamlConst;
import com.yszhdhy.generator.construct.build.Director;
import com.yszhdhy.generator.construct.build.FileBuilder.MyBatisPlusBuilder;
import com.yszhdhy.generator.model.project.Project;
import com.yszhdhy.generator.model.project.ProjectInfo;
import com.yszhdhy.generator.model.vo.FileEntity;
import org.dom4j.DocumentException;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class YamlDisposition {


    public static void construct(String pomPath,Map<String, Object> yamlMap) throws IOException {

        // 创建Java对象并设置其属性：
        Map<String, Object> yamlData = new HashMap<>();

        GouJian(yamlMap,yamlData); // 进行构建

        write(pomPath,yamlData); // 写入文件

    }

    public static void GouJian(Map<String, Object> values, Map<String, Object> yamlData){
        for (String key : values.keySet()) {

            Map<String, Object> curMap = yamlData;
            String[] keys = key.split("\\.");
            System.out.println(Arrays.toString(keys));

            for (int i = 0; i < keys.length; i++) {

                Object o = curMap.get(keys[i]);
                System.out.println(keys[i]);
                if (o instanceof Map && i < keys.length) {
                    Map<String, Object> SpringValue = (Map<String, Object>) curMap.get(keys[i]);
                    curMap = SpringValue;
                }else if (i < keys.length -1){
                    curMap.put(keys[i],new HashMap<String,Object>());
                    curMap = (Map<String, Object>) curMap.get(keys[i]);
                }else{
                    curMap.put(keys[i], values.get(key));
                }
            }
        }
    }



    public static void write(String path, Map<String, Object> yamlData){

        final DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setDefaultScalarStyle(DumperOptions.ScalarStyle.PLAIN);

        //        将Java对象转换为YAML格式并写入文件：  true 表示是否以追加的形式进行写入
        try (FileWriter writer = new FileWriter(path,true)) {
            Yaml yaml = new Yaml(options);
            yaml.dump(yamlData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }









}
