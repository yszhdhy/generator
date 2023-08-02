package com.yszhdhy.generator.construct;

import com.yszhdhy.generator.model.vo.PomAttribute;
import com.yszhdhy.generator.utils.PomUtils;
import com.yszhdhy.generator.utils.SystemUtils;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static com.yszhdhy.generator.constant.common.PackagePath.PACKAGE_SERVICE_PATH;

public class ItemMovement {

    public static void construct(){
        // 当前项目根目录路径
        String projectRootPath = SystemUtils.getProjectPath();
//        String projectRootPath = System.getProperty("user.dir");

        try {
            // 获取当前项目文件夹的名称
            String projectName = new File(projectRootPath).getName();

            // 创建临时文件夹
            File tempFolder = new File(projectRootPath, projectName);
            if (tempFolder.mkdir()) {
                System.out.println("成功创建临时文件夹：" + tempFolder.getAbsolutePath());

                // 将当前项目的内容复制到临时文件夹中
                copyFolder(new File(projectRootPath), tempFolder);


                // 删除原项目文件夹
                deleteFolder(new File(projectRootPath), new File(projectRootPath, projectName));

//                生成文件
                XMLGenerator();


                PomUtils.init(PACKAGE_SERVICE_PATH.getPackagePath()+"/pom.xml");
                PomUtils.modifyDom("com.yszhdhy.generator","groupId");
                PomUtils.modifyDom("1.0","version");

                System.out.println("项目移动成功！");
            } else {
                System.out.println("无法创建临时文件夹：" + tempFolder.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("项目移动失败：" + e.getMessage());
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyFolder(File source, File destination) throws IOException {
        // 如果目标文件夹不存在，则创建它
        if (!destination.exists()) {
            destination.mkdirs();
        }

        // 遍历源文件夹中的所有子文件和子文件夹
        File[] files = source.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.equals(destination)) {
                    return;
                } else {
                    if (file.isDirectory()) {
                        // 递归复制子文件夹
                        copyFolder(file, new File(destination, file.getName()));
                    } else {
                        // 复制文件
                        Files.copy(file.toPath(), new File(destination, file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
        }
    }

    private static void deleteFolder(File folder, File projectName) {
        // 遍历文件夹中的所有文件和子文件夹
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.equals(projectName)) {

                }else {
                    if (file.isDirectory()) {
                        // 递归删除子文件夹
                        deleteFolder(file, null);
                    } else {
                        // 删除文件
                        file.delete();
                    }
                }
            }
        }

        // 删除空文件夹
        folder.delete();
    }



    public static void XMLGenerator() {
        // 创建Document对象
        Document document = DocumentHelper.createDocument();

        Namespace namespace = new Namespace("", "http://maven.apache.org/POM/4.0.0");
        Namespace xsiNamespace = new Namespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");

        // 创建根元素project，并设置命名空间
        Element project = document.addElement(new QName("project",namespace));

        project.add(namespace);
//        project.add(xsiNamespace);

        // 设置xsi:schemaLocation属性
        QName schemaLocationQName = new QName("schemaLocation", xsiNamespace);
        project.addAttribute(schemaLocationQName, "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd");

        // 添加子元素modelVersion
        Element modelVersion = project.addElement("modelVersion");
        modelVersion.setText("4.0.0");

        // 添加其他子元素和属性
        project.addElement("groupId").setText("com.yszhdhy.generator");
        project.addElement("artifactId").setText("generator");
        project.addElement("packaging").setText("pom");
        project.addElement("version").setText("1.0");

        // 创建parent元素并添加子元素
        Element parent = project.addElement("parent");
        parent.addElement("groupId").setText("org.springframework.boot");
        parent.addElement("artifactId").setText("spring-boot-starter-parent");
        parent.addElement("version").setText("2.3.6.RELEASE");

        // 创建properties元素并添加子元素
        Element properties = project.addElement("properties");
        properties.addElement("maven.compiler.source").setText("8");
        properties.addElement("maven.compiler.target").setText("8");
        properties.addElement("project.build.sourceEncoding").setText("UTF-8");
        properties.addElement("java.version").setText("1.8");
        properties.addElement("mybatis-plus.version").setText("3.4.1");
        properties.addElement("mysql.version").setText("8.0.30");
        properties.addElement("knife4j.version").setText("3.0.3");
        properties.addElement("jwt.version").setText("0.9.1");
        properties.addElement("fastjson.version").setText("2.0.21");

        // 在<dependencies xmlns="">和</properties>之间添加间距
        properties.addText("\n    ");



        // 创建modules元素并添加子元素
        Element modules = project.addElement("modules");
        modules.addElement("module").setText(new File(System.getProperty("user.dir")).getName());

        // 在<dependencies xmlns="">和</properties>之间添加间距
        modules.addText("\n    ");

        // 创建依赖管理
        Element dependencyManagement = project.addElement("dependencyManagement");
        Element dependencies = dependencyManagement.addElement("dependencies");
        Element mybatis = dependencies.addElement("dependency");
        mybatis.addElement("groupId").setText("com.baomidou");
        mybatis.addElement("artifactId").setText("mybatis-plus-boot-starter");
        mybatis.addElement("version").setText("${mybatis-plus.version}");

        Element mysql = dependencies.addElement("dependency");
        mysql.addElement("groupId").setText("mysql");
        mysql.addElement("artifactId").setText("mysql-connector-java");
        mysql.addElement("version").setText("${mysql.version}");

        Element fastjson = dependencies.addElement("dependency");
        fastjson.addElement("groupId").setText("com.alibaba");
        fastjson.addElement("artifactId").setText("fastjson");
        fastjson.addElement("version").setText("${fastjson.version}");

        Element knife4j = dependencies.addElement("dependency");
        knife4j.addElement("groupId").setText("com.github.xiaoymin");
        knife4j.addElement("artifactId").setText("knife4j-spring-boot-starter");
        knife4j.addElement("version").setText("${knife4j.version}");

        Element jjwt = dependencies.addElement("dependency");
        jjwt.addElement("groupId").setText("io.jsonwebtoken");
        jjwt.addElement("artifactId").setText("jjwt");
        jjwt.addElement("version").setText("${jwt.version}");

        // 打包插件
        Element build = project.addElement("build");
        Element plugins = build.addElement("plugins");
        Element plugin = plugins.addElement("plugin");
        plugin.addElement("groupId").setText("org.apache.maven.plugins");
        plugin.addElement("artifactId").setText("maven-compiler-plugin");
        plugin.addElement("version").setText("3.1");
        Element configuration = plugin.addElement("configuration");
        configuration.addElement("source").setText("1.8");
        configuration.addElement("target").setText("1.8");



        // 输出XML文件
        try {
            // 创建XMLWriter对象，并设置输出格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setIndent("    "); // 设置缩进为4个空格
            format.setNewlines(true); // 设置换行符
            XMLWriter writer = new XMLWriter(new FileWriter("pom.xml"), format);

            // 输出到文件
            writer.write(document);
            writer.close();

            System.out.println("XML文件生成成功！");
        } catch (IOException e) {
            System.out.println("生成XML文件时发生错误：" + e.getMessage());
        }
    }
}
