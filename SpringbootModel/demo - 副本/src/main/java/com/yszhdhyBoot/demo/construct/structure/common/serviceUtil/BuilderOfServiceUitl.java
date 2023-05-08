package com.yszhdhyBoot.demo.construct.structure.common.serviceUtil;


import com.yszhdhyBoot.demo.constant.common.ModuleGroupId;
import com.yszhdhyBoot.demo.constant.common.PackagePath;
import com.yszhdhyBoot.demo.model.vo.Module;
import com.yszhdhyBoot.demo.model.project.ProjectInfo;
import com.yszhdhyBoot.demo.utils.FileUtils;
import com.yszhdhyBoot.demo.utils.PomResolverUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
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
        FileUtils.construct(info,basePath,ModulePath,packageList, ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId());

        //构建pom文件
        Module module = new Module("modules", moduleName);

//        指定那个pom文件
        PomResolverUtils.construct(basePath+ModulePath+"/pom.xml",
                module,null,
                ModulePath.replaceAll("/",""),
                PackagePath.PACKAGE_COMMON_PATH.getPackagePath(),null);
    }
}
