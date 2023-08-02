package com.yszhdhy.generator.construct.structure.common.commonElasticsearch;

import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.ModulePath;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.construct.build.FileBuilder.*;
import com.yszhdhy.generator.model.project.ProjectInfo;
import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.Module;
import com.yszhdhy.generator.model.vo.PackageVo;
import com.yszhdhy.generator.utils.FileUtils;
import com.yszhdhy.generator.utils.PomAndYamlBuildMap;
import com.yszhdhy.generator.utils.PomResolverUtils;
import com.yszhdhy.generator.utils.PomUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.yszhdhy.generator.constant.common.VoPackageList.*;

/**
 * @project generator
 * @description elasticsearch模块包结构构建
 * @author capture or new
 * @date 2023/7/22 21:52:29
 * @version 1.0
 */
public class BuilderOfElasticsearch {

    public static void BuilderElasticsearch(ProjectInfo info) throws DocumentException, IOException {
        List<PackageVo> packageList = Elasticsearch_PACKAGES.getPackageList();

        //创建 common-elasticsearch 文件夹
        construct(info, PackagePath.PACKAGE_COMMON_PATH.getPackagePath(),
                ModulePath.MODULE_COMMON_ELASTICSEARCH_PATH.getModulePath(),
                ModulePath.MODULE_COMMON_ELASTICSEARCH_PATH.getModulePath().replaceAll("/",""),
                packageList);

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
                                 List<PackageVo> packageList) throws DocumentException, IOException {


//        构建 common 文件夹
        FileUtils.constructRecursion(info,basePath,ModulePath,packageList,
                ModuleGroupId.ELASTICSEARCH_COMMON_MINIO_GROUP_ID.getModuleGroupId());

        //构建pom文件
        Module module = new Module("modules", moduleName);


//        指定那个pom文件
        PomResolverUtils.construct(basePath+ModulePath+"/pom.xml",
                module,
                addDependency(),
                ModulePath.replaceAll("/",""),
                PackagePath.PACKAGE_COMMON_PATH.getPackagePath(),null);


        // 重新指定pom文件  对service 模块中的pom 进行操作
        PomUtils.init(PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/pom.xml");

        // 添加common-elasticsearch模块
        PomUtils.addNodes(PomAndYamlBuildMap.builderPom(new ArrayList<>(),new CommonElasticsearchDependencyBuilder()));

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
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new LombokBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new SpringElasticsearchBuilder());

        return dependencies;
    }
}
