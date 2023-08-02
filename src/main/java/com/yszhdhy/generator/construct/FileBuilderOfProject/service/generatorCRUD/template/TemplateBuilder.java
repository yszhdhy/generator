package com.yszhdhy.generator.construct.FileBuilderOfProject.service.generatorCRUD.template;

import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.constant.common.TemplateFileList;
import com.yszhdhy.generator.utils.FileUtils;
import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 构建CRUD模版文件
 */
public class TemplateBuilder {
//    src/main/resources/
    final static private String sourceFilePath = "generatorCRUD/template/";
    final static private String destinationFilePath = SystemUtils.getProjectPath()
            +"/"+new File(SystemUtils.getProjectPath()).getName()
            + "/src/main/resources/template/";


    public static void construct() throws IOException {

        List<String> files = TemplateFileList.BASE_COMMON_UTIL_PACKAGE.getFiles();

        for (String file : files) {
            FileUtils.FileCreateAndCopy(sourceFilePath+file,destinationFilePath+file);
        }
    }
}
