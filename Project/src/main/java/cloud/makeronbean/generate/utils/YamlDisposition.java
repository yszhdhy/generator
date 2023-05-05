package cloud.makeronbean.generate.utils;

import cloud.makeronbean.generate.constant.code.Knife4jCodeConst;
import cloud.makeronbean.generate.constant.yaml.MyBatisPlusYamlConst;
import cloud.makeronbean.generate.entity.project.ProjectInfo;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class YamlDisposition {

    public static void construct(ProjectInfo info) throws IOException {

        // 创建Java对象并设置其属性：
        Map<String, Object> yamlData = new HashMap<>();
        yamlData.put("spring", new HashMap<String, Object>());
        yamlData.put("server", new HashMap<String, Object>());
        yamlData.put("mybatis-plus", new HashMap<String, Object>());

        MyBatisPlusYamlConst[] values = MyBatisPlusYamlConst.values();

        ArrayList<MyBatisPlusYamlConst> myBatisPlusYamlConsts = new ArrayList<>(Arrays.asList(MyBatisPlusYamlConst.values()));


        write("data.xml",yamlData);


    }

//    public static void GouJian(){
//        for (MyBatisPlusYamlConst value : values) {
//
//            Map<String, Object> curMap = yamlData;
//            String[] keys = value.getKey().split("\\.");
//            System.out.println(Arrays.toString(keys));
//
//            for (int i = 0; i < keys.length; i++) {
//
//                Object o = curMap.get(keys[i]);
//                System.out.println(keys[i]);
//                if (o instanceof Map && i < keys.length) {
//                    Map<String, Object> SpringValue = (Map<String, Object>) curMap.get(keys[i]);
//                    curMap = SpringValue;
//                }else if (i < keys.length -1){
//                    curMap.put(keys[i],new HashMap<String,Object>());
//                    curMap = (Map<String, Object>) curMap.get(keys[i]);
//                }else{
//                    curMap.put(keys[i], value.getDefaultValue());
//                }
//
//            }
//        }
//    }



    public static void write(String path, Map<String, Object> yamlData){

        final DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setDefaultScalarStyle(DumperOptions.ScalarStyle.PLAIN);

        //        将Java对象转换为YAML格式并写入文件：
        try (FileWriter writer = new FileWriter(path)) {
            Yaml yaml = new Yaml(options);
            yaml.dump(yamlData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    public static void main(String[] args) {



//        System.out.println(myBatisPlusYamlConsts);
    }




}
