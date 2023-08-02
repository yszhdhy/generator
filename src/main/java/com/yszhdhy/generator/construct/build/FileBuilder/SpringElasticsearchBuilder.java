package com.yszhdhy.generator.construct.build.FileBuilder;

import com.yszhdhy.generator.constant.dependency.DependencyConst;
import com.yszhdhy.generator.construct.build.Builder;
import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.FileEntity;

import java.util.ArrayList;
import java.util.List;

public class SpringElasticsearchBuilder extends Builder {

    @Override
    public void builderDependency() {
        List<Dependency> dependencies = new ArrayList<>();
        // web依赖
        Dependency dependency = new Dependency();
        dependency.setGroupId("org.springframework.boot");
        dependency.setTabName(DependencyConst.DEPENDENCY.getTabName());
        dependency.setArtifactId("spring-boot-starter-data-elasticsearch");
        dependency.setParentNodeName(DependencyConst.DEPENDENCIES.getTabName());
        dependencies.add(dependency);


        file.setDependencyList(dependencies);
    }

    @Override
    public void buildYaml() {

    }

    @Override
    public void buildCodeTemplate() {

    }

    @Override
    public FileEntity createFile() {
        return file;
    }
}
