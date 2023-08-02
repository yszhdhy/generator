package com.yszhdhy.generator;

import com.yszhdhy.generator.construct.FileBuilderOfProject.service.generatorCRUD.template.TemplateBuilder;
import com.yszhdhy.generator.construct.structure.generatorCRUD.BuilderOfGeneratorCRUD;
import com.yszhdhy.generator.utils.FileUtils;
import com.yszhdhy.generator.utils.PomUtils;
import com.yszhdhy.generator.utils.SystemUtils;
import com.yszhdhy.generator.utils.YamlDisposition;
import org.dom4j.DocumentException;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.yszhdhy.generator.utils.FileUtils.copyImageToFolder;

public class Ceshi {
    public static void main(String[] args) {
        String sourceImagePath = "vue3/src/assets/dashboard.png";
        String destinationFolderPath = "vue4";

        try {
            copyImageToFolder(sourceImagePath, destinationFolderPath);
            System.out.println("Image copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void copyImageToFolder(String sourceImagePath, String destinationFolderPath) throws IOException {
        // 获取资源文件的URL
        ClassLoader classLoader = Ceshi.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(sourceImagePath);

        if (inputStream == null) {
            throw new FileNotFoundException("Source image file not found.");
        }

        // 确保目标文件夹存在
        File destinationFolder = new File(destinationFolderPath);
        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs();
        }

        // 构建目标文件路径
        String destinationImagePath = destinationFolderPath + File.separator + Paths.get(sourceImagePath).getFileName().toString();

        // 复制图片
        try (OutputStream outputStream = new FileOutputStream(destinationImagePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }


}
