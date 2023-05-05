package cloud.makeronbean.generate.resolver.Model;

import cloud.makeronbean.generate.entity.Module;
import cloud.makeronbean.generate.entity.PomAttribute;
import cloud.makeronbean.generate.entity.project.ProjectInfo;
import cloud.makeronbean.generate.entity.starter.BaseStarter;
import cloud.makeronbean.generate.resolver.FileResolver;
import cloud.makeronbean.generate.utils.PomUtils;
import cloud.makeronbean.generate.utils.SystemUtils;
import org.dom4j.DocumentException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ModelPomResolver {

    public static void construct(String pomPath,  Module module, List<BaseStarter.Dependency> dependencyList,String artifactId) throws DocumentException, IOException {
        //指定pom 的位置
        PomUtils.init(pomPath);

        //构建 基本的Pom文件
        PomAttribute pomAttribute = new PomAttribute("2.3.6.RELEASE", artifactId, null);
        PomUtils.BasicConstruction(null, null, pomAttribute);


        //之后要在我们的父项目中 包含 子模块 modules
//        先重新指定pom文件
        PomUtils.init(SystemUtils.getProjectPath()+"/pom.xml");
        //增加一个 module
        PomUtils.addNodesForOther(module);
    }

}
