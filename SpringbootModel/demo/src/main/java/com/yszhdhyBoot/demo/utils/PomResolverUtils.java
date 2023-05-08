package com.yszhdhyBoot.demo.utils;

import com.yszhdhyBoot.demo.constant.common.pom.PomAttributeConstant;
import com.yszhdhyBoot.demo.model.BaseStarter;
import com.yszhdhyBoot.demo.model.vo.Module;
import com.yszhdhyBoot.demo.model.vo.PomAttribute;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;


public class PomResolverUtils {

    public static void construct(String pomPath,
                                 Module module,
                                 List<BaseStarter.Dependency> dependencyList,
                                 String artifactId,
                                 String parentPomPath,
                                 String pomPackage) throws DocumentException, IOException {
        //指定pom 的位置
        PomUtils.init(pomPath);

        //构建 基本的Pom文件
        PomAttribute pomAttribute = new PomAttribute(PomAttributeConstant.POM_ATTRIBUTE_VERSION.getPomAttribute(), artifactId, pomPackage);
        PomUtils.BasicConstruction(null, null, pomAttribute);


        //之后要在我们的父项目中 包含 子模块 modules
//        先重新指定pom文件
        PomUtils.init(parentPomPath+"/pom.xml");
        //增加一个 module
        PomUtils.addNodesForOther(module);
    }
}
