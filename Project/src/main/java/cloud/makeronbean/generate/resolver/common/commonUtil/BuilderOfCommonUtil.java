package cloud.makeronbean.generate.resolver.common.commonUtil;

import cloud.makeronbean.generate.constant.common.ModuleGroupId;
import cloud.makeronbean.generate.constant.common.PackagePath;
import cloud.makeronbean.generate.entity.Module;
import cloud.makeronbean.generate.entity.project.ProjectInfo;
import cloud.makeronbean.generate.utils.FileUtils;
import cloud.makeronbean.generate.utils.PomResolverUtils;
import cloud.makeronbean.generate.utils.SystemUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;

public class BuilderOfCommonUtil {

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
        FileUtils.construct(info,basePath,ModulePath,packageList, ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId());

        //构建pom文件
        Module module = new Module("modules", moduleName);

//        指定那个pom文件
        PomResolverUtils.construct(basePath+ModulePath+"/pom.xml",
                module,null,
                ModulePath.replaceAll("/",""),
                PackagePath.PACKAGE_COMMON_PATH.getPackagePath(),null);
    }
}
