package com.yszhdhy.generator.construct.structure.common;


import com.yszhdhy.generator.constant.common.ModulePath;
import com.yszhdhy.generator.constant.common.PackageList;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.construct.structure.common.commonUtil.BuilderOfCommonUtil;
import com.yszhdhy.generator.construct.structure.common.serviceUtil.BuilderOfServiceUitl;
import com.yszhdhy.generator.model.vo.Module;
import com.yszhdhy.generator.model.project.ProjectInfo;
import com.yszhdhy.generator.utils.FileUtils;
import com.yszhdhy.generator.utils.PomResolverUtils;
import com.yszhdhy.generator.utils.SystemUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;

public class BuilderOfCommon {

    public static void construct(ProjectInfo info, String basePath, String ModulePath) throws DocumentException, IOException {
//        构建 common 文件夹
        FileUtils.construct(info,basePath,ModulePath,null,null);

        //构建pom文件
        Module module = new Module("modules", "common");

//        指定那个pom文件
//        ModelPomResolver.construct(basePath+ModulePath+"/pom.xml",module,null,"model");

        PomResolverUtils.construct(basePath+ModulePath+"/pom.xml",module,null,
                ModulePath.replaceAll("/",""), SystemUtils.getProjectPath(),"pom");


        //创建 common-util
        BuilderCommonUtil(info,basePath);
        //创建 service-util
        BuilderServiceUtil(info,basePath);
    }


    /**
     *  common-util
     * @param info
     * @param basePath
     * @throws DocumentException
     * @throws IOException
     */
    public static void BuilderCommonUtil(ProjectInfo info, String basePath) throws DocumentException, IOException {
        List<String> packages = PackageList.BASE_COMMON_UTIL_PACKAGE.getPackages();

        //创建 common-util 文件夹
        BuilderOfCommonUtil.construct(info, PackagePath.PACKAGE_COMMON_PATH.getPackagePath(),
                ModulePath.MODULE_COMMON_UTIL_PATH.getModulePath(),
                ModulePath.MODULE_COMMON_UTIL_PATH.getModulePath().replaceAll("/",""),
                packages);


    }


    /**
     * service-util
     * @param info
     * @param basePath
     * @throws DocumentException
     * @throws IOException
     */
    public static void BuilderServiceUtil(ProjectInfo info, String basePath) throws DocumentException, IOException {
        List<String> packages = PackageList.BASE_SERVICE_UTIL_PACKAGE.getPackages();

        //创建 service-util 文件夹
        BuilderOfServiceUitl.construct(info, PackagePath.PACKAGE_COMMON_PATH.getPackagePath(),
                ModulePath.MODULE_SERVICE_UTIL_PATH.getModulePath(),
                ModulePath.MODULE_SERVICE_UTIL_PATH.getModulePath().replaceAll("/",""),
                packages);


    }


}
