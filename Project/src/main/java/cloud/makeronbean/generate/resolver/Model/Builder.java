package cloud.makeronbean.generate.resolver.Model;

import cloud.makeronbean.generate.entity.Module;
import cloud.makeronbean.generate.entity.project.ProjectInfo;
import cloud.makeronbean.generate.resolver.FileResolver;
import cloud.makeronbean.generate.utils.SystemUtils;
import org.dom4j.DocumentException;

import java.io.File;
import java.io.IOException;

public class Builder {

    public static void construct(ProjectInfo info, String basePath, String ModulePath) throws DocumentException, IOException {
//        构建文件夹
        FileResolverOfModel.construct(info,basePath,ModulePath);

        //构建pom文件
        Module module = new Module("modules", "model");

//        指定那个pom文件
        ModelPomResolver.construct(basePath+ModulePath+"/pom.xml",module,null,"model");
    }
}
