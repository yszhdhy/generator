# generator
# 项目总介:

## 项目概述：

对于一个多模块的项目 最麻烦的就是对项目创建了，太过于耗费时间 以及文件夹的创建 、 依赖的导入、

配置文件的书写  对于新手来说无非就是需要去到老项目或者是以前的笔记中copy 过来  十分麻烦。对于maven 的多模块创建 如果对于maven不甚了解 有可能还会再创建项目的时候就会报错 真是令人十分头大。然而对于市面上的代码生成器 不是很单一 就是只有表的增删改查，故而 我直接构写了这个多模块项目构建生成器。

## 使用方式：

1. 首先将com文件解压后放入到你的maven 仓库中 

2. 创建一个maven 项目

3. 之后引入这个jar包的依赖

   ```xml
           <dependency> 
               <groupId>com.yszhdhy</groupId>  
               <artifactId>generator</artifactId>  
               <version>1.0-SNAPSHOT</version> 
           </dependency>  
   ```

4. 随便创建 一个文件 内容为：

   ```java
   
   import com.yszhdhy.generator.model.project.Project;
   import org.dom4j.DocumentException;
   
   import java.io.FileNotFoundException;
   
   public class CeShi {
   
       public static void main(String[] args) throws DocumentException, FileNotFoundException {
   
   
           Project project = new Project();
           project.generate();
   
       }
   
   }
   
   ```

5. 运行即可得到：这样的项目结构：![image](https://user-images.githubusercontent.com/104622610/236380068-13badd58-e72a-473d-9691-fd46c5fc2700.png)

1. yaml文件

   ```
   spring:
     jackson:
       time-zone: Asia/Shanghai
       date-format: yyyy-MM-dd
     application:
       name: untitled
     datasource:
       password: '123456'
       driver-class-name: com.mysql.cj.jdbc.Driver
       url: jdbc:mysql://localhost:3306/dbName?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
       username: root
     mvc:
       format:
         date: yyyy-MM-dd
         date-time: yyyy-MM-dd HH:mm:ss
   server:
     port: 8080
   mybatis-plus:
     configuration:
       log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
       map-underscore-to-camel-case: true
     global-config:
       db-config:
         logic-not-delete-value: 0
         logic-delete-value: 1
         logic-delete-field: isDelete
     type-aliases-package: org.example.entity
   
   ```

2. 父pom文件

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
       <modelVersion>4.0.0</modelVersion>  
       <groupId>com.yszhdhy.generator</groupId>  
       <artifactId>generator</artifactId>  
       <packaging>pom</packaging>  
       <version>1.0</version>  
       <parent> 
           <groupId>org.springframework.boot</groupId>  
           <artifactId>spring-boot-starter-parent</artifactId>  
           <version>2.3.6.RELEASE</version> 
       </parent>  
       <properties> 
           <maven.compiler.source>8</maven.compiler.source>  
           <maven.compiler.target>8</maven.compiler.target>  
           <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>  
           <java.version>1.8</java.version> 
       </properties>  
       <modules> 
           <module>untitled</module>  
           <module>model</module>  
           <module>common</module>
       </modules>  
       <dependencies> 
           <dependency> 
               <groupId>org.dom4j</groupId>  
               <artifactId>dom4j</artifactId>  
               <version>2.1.3</version> 
           </dependency> 
       </dependencies> 
   </project>
   
   ```







