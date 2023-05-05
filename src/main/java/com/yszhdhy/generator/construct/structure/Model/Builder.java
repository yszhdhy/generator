package com.yszhdhy.generator.construct.structure.Model;

import com.yszhdhy.generator.model.vo.Module;
import com.yszhdhy.generator.model.project.ProjectInfo;
import org.dom4j.DocumentException;

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
