package com.yszhdhy.generator.utils;

import com.yszhdhy.generator.Ceshi;
import com.yszhdhy.generator.model.vo.PackageVo;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import com.yszhdhy.generator.model.project.ProjectInfo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

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


    public static void constructRecursion(ProjectInfo info,
                                 String basePath,
                                 String ModulePath,
                                 List<PackageVo> packageList,
                                 String basePackagePath){

        File file1 = new File(basePath,ModulePath.replaceAll("/",""));
        file1.mkdir();

//        项目路径
        String pathForModule = info.getBaseGeneratePathForModuleGroupId(basePath, ModulePath,basePackagePath);

        if(!StringUtils.isEmpty(packageList)){
            for (PackageVo packageVo : packageList) {
                mkdir(pathForModule,packageVo);
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
     * 文件读写 复制
     * @param sourceFilePath  源文件路径
     * @param destinationFilePath 目标文件路径
     */
    public static void FileCreateAndCopy(String sourceFilePath,String destinationFilePath){
//        String sourceFilePath = "src/main/resources/generatorCRUD/template/add-or-update.vue.vm";
//        String destinationFilePath = SystemUtils.getProjectPath()+"/add-or-update.vue.vm";

        try {
            // 获取资源文件的输入流
            ClassPathResource resource = new ClassPathResource(sourceFilePath);
            InputStream inputStream = resource.getInputStream();
            // 创建输入流和输出流
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));


            // 创建目标文件目录（如果不存在）
            File destinationFile = new File(destinationFilePath);
            File parentDir = destinationFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

//            BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath));

            // 读取源文件的每一行并写入目标文件
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            // 关闭流
            reader.close();
            writer.close();

            System.out.println("文件内容已成功复制到目标文件。");
        } catch (IOException e) {
            System.out.println("发生IO异常: " + e.getMessage());
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

    /**
     * @author CaptureOrNew
     * @description 复制图片
     * @param sourceImagePath
     * @param destinationFolderPath
     **/
    public static void copyImageToFolder(String sourceImagePath, String destinationFolderPath) throws IOException {
        // 读取源图片文件
        File sourceFile = new File(sourceImagePath);
        if (!sourceFile.exists() || !sourceFile.isFile()) {
            throw new FileNotFoundException("Source image file not found.");
        }

        // 确保目标文件夹存在
        File destinationFolder = new File(destinationFolderPath);
        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs();
        }

        // 构建目标文件路径
        String destinationImagePath = destinationFolderPath + File.separator + sourceFile.getName();

        // 复制图片
        try (InputStream inputStream = new FileInputStream(sourceFile);
             OutputStream outputStream = new FileOutputStream(destinationImagePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void copyImageToFolderResourcesJar(String sourceImagePath, String destinationFolderPath) throws IOException {
        // 获取资源文件的URL
        ClassLoader classLoader = FileUtils.class.getClassLoader();
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
