package com.yszhdhy.generator.construct.build.FileBuilder;



import com.yszhdhy.generator.constant.code.WebCodeConst;
import com.yszhdhy.generator.constant.dependency.DependencyConst;
import com.yszhdhy.generator.constant.yaml.WebYamlConst;
import com.yszhdhy.generator.construct.build.Builder;
import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.FileEntity;

import java.util.*;


public class SpringBootWebBuilder extends Builder {


    @Override
    public void builderDependency() {
        ArrayList<Dependency> dependencies = new ArrayList<>();

        // web依赖
        Dependency dependency = new Dependency();
        dependency.setGroupId("org.springframework.boot");
        dependency.setTabName(DependencyConst.DEPENDENCY.getTabName());
        dependency.setArtifactId("spring-boot-starter-web");
        dependency.setParentNodeName(DependencyConst.DEPENDENCIES.getTabName());
        dependencies.add(dependency);

        // 数据校验依赖
        Dependency dependency1 = new Dependency();
        dependency1.setGroupId("org.springframework.boot");
        dependency1.setTabName(DependencyConst.DEPENDENCY.getTabName());
        dependency1.setArtifactId("spring-boot-starter-validation");
        dependency1.setParentNodeName(DependencyConst.DEPENDENCIES.getTabName());
        dependencies.add(dependency1);

        file.setDependencyList(dependencies);
    }

    @Override
    public void buildYaml() {
        Map<String, Object> resultMap = new HashMap<>();

        // mvc 默认配置
        for (WebYamlConst value : WebYamlConst.values()) {
            resultMap.put(value.getKey(), value.getDefaultValue());
        }

        file.setYamlMap(resultMap);
    }

    @Override
    public void buildCodeTemplate() {
        ArrayList arrayList = new ArrayList<>(Arrays.asList(WebCodeConst.values()));
        file.setCodeTemplateList(arrayList);
    }

    @Override
    public FileEntity createFile() {
        return file;
    }
}
