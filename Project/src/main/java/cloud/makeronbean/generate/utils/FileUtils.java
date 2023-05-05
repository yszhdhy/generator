package cloud.makeronbean.generate.utils;

import cloud.makeronbean.generate.entity.project.ProjectInfo;
import cloud.makeronbean.generate.resolver.FileResolver;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.List;

public class FileUtils {

    public static void construct(ProjectInfo info,
                                 String basePath,
                                 String ModulePath,
                                 List<String> packageList,
                                 String basePackagePath){
        FileResolver instance = FileResolver.getInstance();

        File file1 = new File(basePath,ModulePath.replaceAll("/",""));
        file1.mkdir();

//        项目路径
        String pathForModule = info.getBaseGeneratePathForModuleGroupId(basePath, ModulePath,basePackagePath);


        if(!StringUtils.isEmpty(packageList)){
            for (String file : packageList) {
//            项目路劲+ 包路径
                instance.mkdir(pathForModule, "/"+file);
            }
        }

    }
}
