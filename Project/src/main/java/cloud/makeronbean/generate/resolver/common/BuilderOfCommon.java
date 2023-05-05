package cloud.makeronbean.generate.resolver.common;

import cloud.makeronbean.generate.constant.common.ModulePath;
import cloud.makeronbean.generate.constant.common.PackageList;
import cloud.makeronbean.generate.constant.common.PackagePath;
import cloud.makeronbean.generate.entity.Module;
import cloud.makeronbean.generate.entity.project.ProjectInfo;
import cloud.makeronbean.generate.resolver.common.commonUtil.BuilderOfCommonUtil;
import cloud.makeronbean.generate.utils.FileUtils;
import cloud.makeronbean.generate.utils.PomResolverUtils;
import cloud.makeronbean.generate.utils.SystemUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Arrays;
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
