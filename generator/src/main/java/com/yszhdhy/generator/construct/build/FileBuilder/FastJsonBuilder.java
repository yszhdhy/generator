package com.yszhdhy.generator.construct.build.FileBuilder;

import com.yszhdhy.generator.constant.dependency.DependencyConst;
import com.yszhdhy.generator.construct.build.Builder;
import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.FileEntity;

import java.util.ArrayList;
import java.util.List;

public class FastJsonBuilder extends Builder {

    @Override
    public void builderDependency() {
        List<Dependency> dependencies = new ArrayList<>();
        Dependency dependency = new Dependency();
        dependency.setGroupId("com.alibaba");
        dependency.setTabName(DependencyConst.DEPENDENCY.getTabName());
        dependency.setArtifactId("fastjson");
        dependency.setVersion("2.0.21");
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
