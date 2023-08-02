package com.yszhdhy.generator.construct.structure.common.commonSecurity;

import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.ModulePath;
import com.yszhdhy.generator.constant.common.PackageList;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.construct.build.FileBuilder.*;
import com.yszhdhy.generator.construct.structure.common.commonUtil.BuilderOfCommonUtil;
import com.yszhdhy.generator.model.project.ProjectInfo;
import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.Module;
import com.yszhdhy.generator.utils.FileUtils;
import com.yszhdhy.generator.utils.PomAndYamlBuildMap;
import com.yszhdhy.generator.utils.PomResolverUtils;
import com.yszhdhy.generator.utils.PomUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @project generator
 * @description security 模块
 * @author capture or new
 * @date 2023/7/22 08:34:37
 * @version 1.0
 */
public class BuilderOfSecurity {


    public static void BuilderSecurity(ProjectInfo info) throws DocumentException, IOException {
        List<String> packages = PackageList.BASE_COMMON_SECURITY_PACKAGE.getPackages();

        //创建 common-util 文件夹
        construct(info, PackagePath.PACKAGE_COMMON_PATH.getPackagePath(),
                ModulePath.MODULE_COMMON_SECURITY_PATH.getModulePath(),
                ModulePath.MODULE_COMMON_SECURITY_PATH.getModulePath().replaceAll("/",""),
                packages);

    }

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
        FileUtils.construct(info,basePath,ModulePath,packageList,
                ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId());

        //构建pom文件
        Module module = new Module("modules", moduleName);


//        指定那个pom文件
        PomResolverUtils.construct(basePath+ModulePath+"/pom.xml",
                module,
                addDependency(),
                ModulePath.replaceAll("/",""),
                PackagePath.PACKAGE_COMMON_PATH.getPackagePath(),null);


        // 重新指定pom文件  对service-util 模块中的pom 进行操作
        PomUtils.init(PackagePath.PACKAGE_SERVICE_UTIL_PATH.getPackagePath()+"/pom.xml");

        // 添加security依赖
        PomUtils.addNodes(PomAndYamlBuildMap.builderPom(new ArrayList<>(),new SpringSecurityBuilder()));

        // 重新指定pom文件  对service 模块中的pom 进行操作
        PomUtils.init(PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/pom.xml");

        // 添加common-security模块
        PomUtils.addNodes(PomAndYamlBuildMap.builderPom(new ArrayList<>(),new CommonSecurityBuilder()));

    }


    /**
     * pom中需要添加的依赖
     * @return
     * @throws IOException
     */
    public static List<Dependency> addDependency() throws IOException, DocumentException {

        //构建 dependencies 集合
        List<Dependency> dependencies =new ArrayList<>();
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new SpringBootWebBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new CommonUtilBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new ModelBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new SpringSecurityBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new SpringRedisBuilder());

        return dependencies;
    }
}
