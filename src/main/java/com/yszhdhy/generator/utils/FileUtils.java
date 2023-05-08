package com.yszhdhy.generator.utils;

import com.yszhdhy.generator.model.vo.PackageVo;
import org.springframework.util.StringUtils;

import com.yszhdhy.generator.model.project.ProjectInfo;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUtils {

    public static void construct(ProjectInfo info,
                                 String basePath,
                                 String ModulePath,
                                 List<String> packageList,
                                 String basePackagePath){

        File file1 = new File(basePath,ModulePath.replaceAll("/",""));
        file1.mkdir();

//        项目路径
        String pathForModule = info.getBaseGeneratePathForModuleGroupId(basePath, ModulePath,basePackagePath);


        if(!StringUtils.isEmpty(packageList)){
            for (String file : packageList) {
//            项目路劲+ 包路径
                mkdir(pathForModule, "/"+file);
            }
        }

    }

    /**
     * 创建文件
     *
     * @param basePackage 包路径
     * @param name        包名
     */
    public static void mkdir(String basePackage, String name) {
        File file = new File(basePackage + "/" + name);
        if (!file.exists()) {
            file.mkdirs();
        }
    }


    public static void mkdir(String basePackage, PackageVo packageVo) {
        String filePath = basePackage + "/" + packageVo.getPackageName();
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }

        if(!StringUtils.isEmpty(packageVo.getChildPackage())){
            for (PackageVo vo : packageVo.getChildPackage()) {
                mkdir(filePath,vo);
            }
        }

    }

    /**
     * 创建一个空文件
     *
     * @param path
     * @throws IOException
     */
    public static void touch(String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
    }


}
