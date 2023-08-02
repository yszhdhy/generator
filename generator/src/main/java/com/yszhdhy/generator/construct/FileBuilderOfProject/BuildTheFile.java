package com.yszhdhy.generator.construct.FileBuilderOfProject;

import com.yszhdhy.generator.constant.code.CodeTemplate;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.constant.common.pom.PomAttributeConstant;
import com.yszhdhy.generator.constant.common.yaml.YamlPath;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.commonUtil.*;
import com.yszhdhy.generator.construct.FileBuilderOfProject.common.serviceUtil.*;
import com.yszhdhy.generator.construct.FileBuilderOfProject.model.ModelModelFileBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.ServiceModelFileBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.SpringbootInitiate;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.generatorCRUD.GeneratorCRUDModelFileBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.generatorCRUD.template.TemplateBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.generatorCRUD.templates.TemplatesBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.generatorCRUD.utils.OtherUtilsBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.pom.PomInitiate;
import com.yszhdhy.generator.construct.FileBuilderOfProject.service.yaml.YamlInitiate;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.VueBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.VueModelFileBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.AppBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.icons.svg.SvgBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.layout.LayoutBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.router.RouterBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.store.StoreBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.styles.StylesBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.utils.UtilsBuilder;
import com.yszhdhy.generator.construct.FileBuilderOfProject.vue.src.views.ViewsBuilder;
import com.yszhdhy.generator.construct.build.FileBuilder.*;
import com.yszhdhy.generator.model.project.ProjectInfo;
import com.yszhdhy.generator.model.vo.Dependency;
import com.yszhdhy.generator.model.vo.OtherNode;
import com.yszhdhy.generator.utils.MkdirFileWriteUtils;
import com.yszhdhy.generator.utils.PomAndYamlBuildMap;
import com.yszhdhy.generator.utils.PomUtils;
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
        map = PomAndYamlBuildMap.builderYaml(map, new MyBatisPlusBuilder());
        map = PomAndYamlBuildMap.builderYaml(map,new SpringBootParentBuilder());
        map = PomAndYamlBuildMap.builderYaml(map,new SpringBootWebBuilder());


        //构建 yaml
        YamlInitiate.construct(YamlPath.YAML_PATH.getYamlPath(), map);


        PomUtils.init(PackagePath.PACKAGE_COMMON_PATH.getPackagePath()+"/pom.xml");
        //构建 dependencies 集合
        List<Dependency> dependencies =new ArrayList<>();
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new SpringBootWebBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new LombokBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new ModelBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new ServiceUtilBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new ThymeleafBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new MyBatisPlusBuilder());
        dependencies = PomAndYamlBuildMap.builderPom(dependencies,new CommonsIoBuilder());


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

        PomUtils.addResource();


        //构建所有的文件
        serviceUtil();
        commonUtil();
        model();
        service();
//        vue();
        generatorCURD();
    }

    public static void serviceUtil() throws IOException {
        ServiceUtilModelFileBuilder.construct();
    }

    public static void commonUtil() throws IOException {
        CommonUtilModelFileBuilder.construct();
    }


    public static void model() throws IOException {
        ModelModelFileBuilder.construct();
    }


    public static void service() throws IOException {
        ServiceModelFileBuilder.construct();
    }


    public static void vue() throws IOException {
        SvgBuilder.construct();
        LayoutBuilder.builderObj();
        RouterBuilder.builderObj();
        StoreBuilder.builderObj();
        StylesBuilder.builderObj();
        UtilsBuilder.builderObj();

        ViewsBuilder.builderObj();
        AppBuilder.builderObj();
        VueBuilder.builderObj();
        VueModelFileBuilder.construct();

    }

    public static void generatorCURD() throws IOException{
        OtherUtilsBuilder.construct();
        GeneratorCRUDModelFileBuilder.construct();
//        模版文件
        TemplateBuilder.construct();
        TemplatesBuilder.construct();
    }

}
