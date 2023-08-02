package com.yszhdhy.generator.utils;

import com.yszhdhy.generator.construct.FileBuilderOfProject.service.pom.PomInitiate;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.yaml.YamlInitiate;
import com.yszhdhy.generator.construct.build.Builder;
import com.yszhdhy.generator.construct.build.Director;
import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.FileEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PomAndYamlBuildMap {

    public static Map<String, Object> builderYaml(Map<String, Object> map, Builder builder) throws IOException {
        //构建mybatis
        Director director = new Director(builder);
        FileEntity fileEntity = director.construct();

        Map<String, Object> assemble = YamlInitiate.assemble(map,fileEntity.getYamlMap());

        return assemble;
    }



    public static List<Dependency> builderPom(List<Dependency> dependencies, Builder builder) throws IOException {
        //指挥者 进行构建
        Director director = new Director(builder);
        FileEntity fileEntity = director.construct();

        List<Dependency> assemble = PomInitiate.assemble(dependencies,fileEntity.getDependencyList());

        return assemble;
    }
}
