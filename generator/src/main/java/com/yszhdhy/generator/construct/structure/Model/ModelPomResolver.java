package com.yszhdhy.generator.construct.structure.Model;

import com.yszhdhy.generator.constant.common.pom.PomAttributeConstant;
import com.yszhdhy.generator.construct.build.FileBuilder.Knife4jBuilder;
import com.yszhdhy.generator.construct.build.FileBuilder.LombokBuilder;
import com.yszhdhy.generator.construct.build.FileBuilder.MyBatisPlusBuilder;
import com.yszhdhy.generator.construct.build.FileBuilder.SpringBootWebBuilder;
import com.yszhdhy.generator.model.BaseStarter;
import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.Module;
import com.yszhdhy.generator.model.vo.PomAttribute;
import com.yszhdhy.generator.utils.PomAndYamlBuildMap;
import com.yszhdhy.generator.utils.PomUtils;
import com.yszhdhy.generator.utils.SystemUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelPomResolver {

    public static void construct(String pomPath, Module module, List<BaseStarter.Dependency> dependencyList, String artifactId) throws DocumentException, IOException {
        //指定pom 的位置
        PomUtils.init(pomPath);

        //构建 基本的Pom文件
        PomAttribute pomAttribute = new PomAttribute(PomAttributeConstant.POM_ATTRIBUTE_VERSION.getPomAttribute(), artifactId, null);
        PomUtils.BasicConstruction(null, null, pomAttribute);

        //添加依赖
        addDependency();


        //之后要在我们的父项目中 包含 子模块 modules
//        先重新指定pom文件
        PomUtils.init(SystemUtils.getProjectPath()+"/pom.xml");
        //增加一个 module
        PomUtils.addNodesForOther(module);


    }

    public static void addDependency() throws IOException {
        //构建 dependencies 集合
        List<Dependency> dependencies =new ArrayList<>();
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new MyBatisPlusBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new LombokBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new Knife4jBuilder());

        PomUtils.addNodes(dependencies); // 添加依赖
    }

}
