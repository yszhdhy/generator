package com.yszhdhy.generator.construct.FileBuilderOfProject.service.pom;

import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.utils.PomUtils;
import com.yszhdhy.generator.utils.YamlDisposition;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PomInitiate {

    public static void construct(String pomPath,List<Dependency> dependencies) throws IOException, DocumentException {

        PomUtils.init(pomPath); //初始化
        PomUtils.addNodes(dependencies); // 添加依赖
    }


    /**
     * 组装 dependencies
     * @param dependencies1
     * @param dependencies2
     * @return
     */
    public static List<Dependency> assemble(List<Dependency> dependencies1, List<Dependency> dependencies2){

        for (Dependency dependency : dependencies2) {
            dependencies1.add(dependency);
        }

        return dependencies1;
    }
}
