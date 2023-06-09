package com.yszhdhy.generator.construct.structure.common.serviceUtil;


import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.construct.build.FileBuilder.*;
import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.Module;
import com.yszhdhy.generator.model.project.ProjectInfo;
import com.yszhdhy.generator.utils.FileUtils;
import com.yszhdhy.generator.utils.PomAndYamlBuildMap;
import com.yszhdhy.generator.utils.PomResolverUtils;
import com.yszhdhy.generator.utils.PomUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuilderOfServiceUitl {

    /**
     * @param info
     * @param basePath  项目路径
     * @param ModulePath 要创建的模块名称 + /
     * @param moduleName 要创建的模块名称
     * @param packageList  要在模块中创建的包
     * @throws DocumentException
     * @throws IOException
     */
    public static void construct(ProjectInfo info,
                                 String basePath,
                                 String ModulePath,
                                 String moduleName,
                                 List<String> packageList) throws DocumentException, IOException {


//        构建 common 文件夹
        FileUtils.construct(info,basePath,ModulePath,packageList, ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId());

        //构建pom文件
        Module module = new Module("modules", moduleName);

//        指定那个pom文件
        PomResolverUtils.construct(basePath+ModulePath+"/pom.xml",
                module,
                addDependency(),
                ModulePath.replaceAll("/",""),
                PackagePath.PACKAGE_COMMON_PATH.getPackagePath(),null);
    }


    /**
     * pom中需要添加的依赖
     * @return
     * @throws IOException
     */
    public static List<Dependency> addDependency() throws IOException, DocumentException {
        //构建 dependencies 集合
        List<Dependency> dependencies =new ArrayList<>();
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new MyBatisPlusBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new SpringBootWebBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new Knife4jBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new LombokBuilder());
//        PomUtils.init(PackagePath.PACKAGE_COMMON_PATH.getPackagePath()+"/pom.xml");
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new CommonUtilBuilder());

        return dependencies;
    }
}
