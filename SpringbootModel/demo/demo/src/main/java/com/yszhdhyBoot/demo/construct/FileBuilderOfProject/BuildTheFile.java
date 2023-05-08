package com.yszhdhyBoot.demo.construct.FileBuilderOfProject;


import com.yszhdhyBoot.demo.constant.code.CodeTemplate;
import com.yszhdhyBoot.demo.constant.common.PackagePath;
import com.yszhdhyBoot.demo.constant.common.pom.PomAttributeConstant;
import com.yszhdhyBoot.demo.constant.common.yaml.YamlPath;
import com.yszhdhyBoot.demo.construct.FileBuilderOfProject.service.SpringbootInitiate;
import com.yszhdhyBoot.demo.construct.FileBuilderOfProject.service.pom.PomInitiate;
import com.yszhdhyBoot.demo.construct.FileBuilderOfProject.service.yaml.YamlInitiate;
import com.yszhdhyBoot.demo.construct.build.Builder;
import com.yszhdhyBoot.demo.construct.build.Director;
import com.yszhdhyBoot.demo.construct.build.FileBuilder.MyBatisPlusBuilder;
import com.yszhdhyBoot.demo.construct.build.FileBuilder.SpringBootParentBuilder;
import com.yszhdhyBoot.demo.construct.build.FileBuilder.SpringBootWebBuilder;
import com.yszhdhyBoot.demo.model.project.ProjectInfo;
import com.yszhdhyBoot.demo.model.vo.Dependency;
import com.yszhdhyBoot.demo.model.vo.FileEntity;
import com.yszhdhyBoot.demo.model.vo.OtherNode;
import com.yszhdhyBoot.demo.utils.MkdirFileWriteUtils;
import com.yszhdhyBoot.demo.utils.PomUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 构建文件
 */
public class BuildTheFile {

    public static void construct(List<CodeTemplate> codeTemplateList, String filePath, String GroupId) throws IOException {

        MkdirFileWriteUtils.write(codeTemplateList,filePath,GroupId);
    }


    /**
     * 构建启动类 和 yaml
     * @param info
     * @throws IOException
     */
    public static void buildTheFile(ProjectInfo info) throws IOException, DocumentException {

        SpringbootInitiate.construct(info);


        //构建 yaml map
        Map<String, Object> map = new HashMap<>();
        map = builderYaml(map, new MyBatisPlusBuilder());
        map = builderYaml(map,new SpringBootParentBuilder());
        map = builderYaml(map,new SpringBootWebBuilder());


        //构建 dependencies 集合
        List<Dependency> dependencies =new ArrayList<>();
        dependencies = builderPom(dependencies,new SpringBootWebBuilder());


        //构建 yaml
        YamlInitiate.construct(YamlPath.YAML_PATH.getYamlPath(), map);


        //向pom中注入依赖
        PomInitiate.construct(PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/pom.xml",dependencies);


        //之后进行还要进行设置 parent 因为用户自己创建的 一个maven 不包含
        OtherNode otherNode = new OtherNode();
        otherNode.setParentNodeName("parent");

        List<OtherNode.Node> nodes = new ArrayList<>();
        nodes.add(new OtherNode.Node("groupId","org.springframework.boot"));
        nodes.add(new OtherNode.Node("artifactId","spring-boot-starter-parent"));
        nodes.add(new OtherNode.Node("version", PomAttributeConstant.POM_ATTRIBUTE_VERSION.getPomAttribute()));
        nodes.add(new OtherNode.Node("relativePath", ""));
        otherNode.setNodes(nodes);

        PomUtils.addOtherNodes(otherNode);
    }


    public static Map<String, Object> builderYaml(Map<String, Object> map, Builder builder) throws IOException {
        //构建mybatis
        Director director = new Director(builder);
        FileEntity fileEntity = director.construct();

        Map<String, Object> assemble = YamlInitiate.assemble(map,fileEntity.getYamlMap());

        return assemble;
    }


    public static List<Dependency> builderPom(List<Dependency> dependencies, Builder builder) throws IOException {
        //构建mybatis
        Director director = new Director(builder);
        FileEntity fileEntity = director.construct();

        List<Dependency> assemble = PomInitiate.assemble(dependencies,fileEntity.getDependencyList());

        return assemble;
    }


}
