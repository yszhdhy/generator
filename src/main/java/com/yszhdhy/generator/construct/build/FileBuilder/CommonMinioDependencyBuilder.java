package com.yszhdhy.generator.construct.build.FileBuilder;

import com.yszhdhy.generator.constant.common.ModulePath;
import com.yszhdhy.generator.constant.dependency.DependencyConst;
import com.yszhdhy.generator.construct.build.Builder;
import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.FileEntity;
import com.yszhdhy.generator.utils.PomUtils;

import java.util.ArrayList;
import java.util.List;

public class CommonMinioDependencyBuilder extends Builder {

    @Override
    public void builderDependency() {
        List<Dependency> dependencies = new ArrayList<>();
        Dependency dependency = new Dependency();
        dependency.setGroupId(PomUtils.getSingleValue("groupId"));
        dependency.setTabName(DependencyConst.DEPENDENCY.getTabName());
        dependency.setArtifactId(ModulePath.MODULE_COMMON_MINIO_PATH.getModulePath().replaceAll("/",""));
        dependency.setVersion(PomUtils.getSingleValue("version"));
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
