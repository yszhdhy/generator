package com.yszhdhyBoot.demo.construct.structure.common;


import com.yszhdhyBoot.demo.constant.common.ModulePath;
import com.yszhdhyBoot.demo.constant.common.PackageList;
import com.yszhdhyBoot.demo.constant.common.PackagePath;
import com.yszhdhyBoot.demo.construct.structure.common.commonUtil.BuilderOfCommonUtil;
import com.yszhdhyBoot.demo.model.vo.Module;
import com.yszhdhyBoot.demo.model.project.ProjectInfo;
import com.yszhdhyBoot.demo.utils.FileUtils;
import com.yszhdhyBoot.demo.utils.PomResolverUtils;
import com.yszhdhyBoot.demo.utils.SystemUtils;
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

        //创建 common-util 文件夹
        BuilderOfCommonUtil.construct(info, PackagePath.PACKAGE_COMMON_PATH.getPackagePath(),
                ModulePath.MODULE_SERVICE_UTIL_PATH.getModulePath(),
                ModulePath.MODULE_SERVICE_UTIL_PATH.getModulePath().replaceAll("/",""),
                packages);


    }


}
