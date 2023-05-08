package com.yszhdhyBoot.demo.construct.build.FileBuilder;

import com.yszhdhyBoot.demo.constant.code.SpringParentCodeConst;
import com.yszhdhyBoot.demo.constant.dependency.DependencyConst;
import com.yszhdhyBoot.demo.constant.yaml.SpringBootParentYamlConst;
import com.yszhdhyBoot.demo.construct.build.Builder;
import com.yszhdhyBoot.demo.model.vo.Dependency;
import com.yszhdhyBoot.demo.model.vo.FileEntity;

import java.util.*;

public class SpringBootParentBuilder extends Builder {

    @Override
    public void builderDependency() {
        List<Dependency> dependencies = new ArrayList<>();
        Dependency dependency = new Dependency();
        dependency.setTabName(DependencyConst.PARENT.getTabName());
        dependency.setGroupId("org.springframework.boot");
        dependency.setArtifactId("spring-boot-starter-parent");
        dependency.setVersion("2.3.6.RELEASE");
        dependency.setParentNodeName(DependencyConst.PROJECT.getTabName());
        dependencies.add(dependency);

        file.setDependencyList(dependencies);
    }

    @Override
    public void buildYaml() {
        Map<String, Object> resultMap = new HashMap<>();

        // mvc 默认配置
        for (SpringBootParentYamlConst value : SpringBootParentYamlConst.values()) {
            resultMap.put(value.getKey(), value.getDefaultValue());
        }

        file.setYamlMap(resultMap);
    }

    @Override
    public void buildCodeTemplate() {
        ArrayList arrayList = new ArrayList<>(Arrays.asList(SpringParentCodeConst.values()));
        file.setCodeTemplateList(arrayList);
    }

    @Override
    public FileEntity createFile() {
        return file;
    }
}
