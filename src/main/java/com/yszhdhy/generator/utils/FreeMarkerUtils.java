package com.yszhdhy.generator.utils;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerUtils {

    public static void parse(String fileName, Map<String, Object> data, String toPath, String basePackagePath) throws IOException {

        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
//        模板文件所在的文件夹
//        cfg.setDirectoryForTemplateLoading(new File("E:/project/kun/moreModule/generator/src/main/resources/service-util"));
        cfg.setTemplateLoader(new ClassTemplateLoader(FreeMarkerUtils.class, basePackagePath));

//        模版文件名称
        Template template = cfg.getTemplate(fileName);

//        模版文件输出位置和 data为模版中需要替换的内容
        try (Writer out = new FileWriter(toPath)) {
            template.process(data, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }


}
