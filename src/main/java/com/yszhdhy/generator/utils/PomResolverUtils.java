package com.yszhdhy.generator.utils;

import com.yszhdhy.generator.constant.common.pom.PomAttributeConstant;
import com.yszhdhy.generator.construct.build.FileBuilder.Knife4jBuilder;
import com.yszhdhy.generator.construct.build.FileBuilder.LombokBuilder;
import com.yszhdhy.generator.construct.build.FileBuilder.MyBatisPlusBuilder;

import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.Module;
import com.yszhdhy.generator.model.vo.PomAttribute;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PomResolverUtils {

    public static void construct(String pomPath,
                                 Module module,
                                 List<Dependency> dependencyList,
                                 String artifactId,
                                 String parentPomPath,
                                 String pomPackage) throws DocumentException, IOException {
        //指定pom 的位置
        PomUtils.init(pomPath);

        //构建 基本的Pom文件
        PomAttribute pomAttribute = new PomAttribute(PomAttributeConstant.POM_ATTRIBUTE_VERSION.getPomAttribute(), artifactId, pomPackage);

        //构建依赖

        PomUtils.BasicConstruction(null, dependencyList, pomAttribute);


        //之后要在我们的父项目中 包含 子模块 modules
//        先重新指定pom文件
        PomUtils.init(parentPomPath+"/pom.xml");
        //增加一个 module
        PomUtils.addNodesForOther(module);
    }



}
