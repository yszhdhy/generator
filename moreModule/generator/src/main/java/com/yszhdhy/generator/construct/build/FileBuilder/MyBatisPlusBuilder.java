package com.yszhdhy.generator.construct.build.FileBuilder;

import com.yszhdhy.generator.constant.code.MyBatisPlusCodeConst;
import com.yszhdhy.generator.constant.dependency.DependencyConst;
import com.yszhdhy.generator.constant.yaml.MyBatisPlusYamlConst;
import com.yszhdhy.generator.construct.build.Builder;
import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.FileEntity;

import java.util.*;

/**
 * 构建 MyBatisPlus
 */
public class MyBatisPlusBuilder extends Builder {

    @Override
    public void builderDependency() {
        List<Dependency> dependencies = new ArrayList<>();

        Dependency mybatis = new Dependency();
        mybatis.setTabName(DependencyConst.DEPENDENCY.getTabName());
        mybatis.setGroupId("com.baomidou");
        mybatis.setArtifactId("mybatis-plus-boot-starter");
        mybatis.setVersion("3.4.1");
        mybatis.setParentNodeName(DependencyConst.DEPENDENCIES.getTabName());
        dependencies.add(mybatis);

        Dependency mysql = new Dependency();
        mysql.setTabName(DependencyConst.DEPENDENCY.getTabName());
        mysql.setGroupId("mysql");
        mysql.setArtifactId("mysql-connector-java");
        mysql.setVersion("8.0.30");
        mysql.setParentNodeName(DependencyConst.DEPENDENCIES.getTabName());
        dependencies.add(mysql);

        file.setDependencyList(dependencies);
    }

    @Override
    public void buildYaml() {
        Map<String, Object> resultMap = new HashMap<>();

        // mvc 默认配置
        for (MyBatisPlusYamlConst value : MyBatisPlusYamlConst.values()) {
            resultMap.put(value.getKey(), value.getDefaultValue());
        }

        file.setYamlMap(resultMap);
    }

    @Override
    public void buildCodeTemplate() {
        ArrayList arrayList = new ArrayList<>(Arrays.asList(MyBatisPlusCodeConst.values()));
        file.setCodeTemplateList(arrayList);
    }

    @Override
    public FileEntity createFile() {
        return file;
    }
}
