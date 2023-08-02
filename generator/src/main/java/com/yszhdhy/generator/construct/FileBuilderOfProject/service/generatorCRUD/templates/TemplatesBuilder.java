package com.yszhdhy.generator.construct.FileBuilderOfProject.service.generatorCRUD.templates;

import com.yszhdhy.generator.constant.common.TemplateFileList;
import com.yszhdhy.generator.utils.FileUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 构建CRUD模版文件
 */
public class TemplatesBuilder {
//    src/main/resources/
    final static private String sourceFilePath = "generatorCRUD/templates/";
    final static private String destinationFilePath = SystemUtils.getProjectPath()
            +"/"+new File(SystemUtils.getProjectPath()).getName()
            + "/src/main/resources/templates/";


    public static void construct() throws IOException {
       String  file = "index.html";
//        List<String> files = TemplateFileList.BASE_COMMON_UTIL_PACKAGE.getFiles();

//        for (String file : files) {
            FileUtils.FileCreateAndCopy(sourceFilePath+file,destinationFilePath+file);
//        }
    }
}
