package com.yszhdhy.generator.construct.structure.Model;

import com.yszhdhy.generator.constant.common.pom.PomAttributeConstant;
import com.yszhdhy.generator.model.BaseStarter;
import com.yszhdhy.generator.model.vo.Module;
import com.yszhdhy.generator.model.vo.PomAttribute;
import com.yszhdhy.generator.utils.PomUtils;
import com.yszhdhy.generator.utils.SystemUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;

public class ModelPomResolver {

    public static void construct(String pomPath, Module module, List<BaseStarter.Dependency> dependencyList, String artifactId) throws DocumentException, IOException {
        //指定pom 的位置
        PomUtils.init(pomPath);

        //构建 基本的Pom文件
        PomAttribute pomAttribute = new PomAttribute(PomAttributeConstant.POM_ATTRIBUTE_VERSION.getPomAttribute(), artifactId, null);
        PomUtils.BasicConstruction(null, null, pomAttribute);


        //之后要在我们的父项目中 包含 子模块 modules
//        先重新指定pom文件
        PomUtils.init(SystemUtils.getProjectPath()+"/pom.xml");
        //增加一个 module
        PomUtils.addNodesForOther(module);
    }

}
