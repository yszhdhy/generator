package com.yszhdhyBoot.demo.utils;

import com.yszhdhyBoot.demo.constant.dependency.DependencyConst;
import com.yszhdhyBoot.demo.model.vo.Dependency;
import com.yszhdhyBoot.demo.model.vo.Module;
import com.yszhdhyBoot.demo.model.vo.OtherNode;
import com.yszhdhyBoot.demo.model.vo.PomAttribute;
import lombok.SneakyThrows;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PomUtils {

    private static Document document;

    private static String pomFile;
    private static final String URL = "http://maven.apache.org/POM/4.0.0";


    /**
     * 初始化指定 pom文件位置
     * @param pomPath
     * @throws DocumentException
     * @throws FileNotFoundException
     */
    public static void init(String pomPath) throws DocumentException, FileNotFoundException {
        pomFile = pomPath;
        System.out.println(pomPath);
        File file = new File(pomPath);
        if(file.exists()){
            document = new SAXReader().read(new File(pomPath));
        }

    }

    /**
     * 构建一个基本的pom文件
     */
    public static void BasicConstruction(Module module, List<Dependency> dependencyList, PomAttribute pomAttribute) throws DocumentException, IOException {
        // 创建Document对象
        document = DocumentHelper.createDocument();

        // 创建根元素project，并设置命名空间
        Namespace namespace = new Namespace("", "http://maven.apache.org/POM/4.0.0");
        Namespace xsiNamespace = new Namespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        // 创建根元素project，并设置命名空间
        Element project = document.addElement(new QName("project",namespace));

        project.add(namespace);

        // 设置xsi:schemaLocation属性
        QName schemaLocationQName = new QName("schemaLocation", xsiNamespace);
        project.addAttribute(schemaLocationQName, "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd");

        // 添加子元素modelVersion
        Element modelVersion = project.addElement("modelVersion");
        modelVersion.setText("4.0.0");

        // 添加其他子元素和属性
        project.addElement("groupId").setText("com.example.demo");
        project.addElement("artifactId").setText(pomAttribute.getArtifactId());

        if(!StringUtils.isEmpty(pomAttribute.getPackaging())){
            project.addElement("packaging").setText(pomAttribute.getPackaging());
        }

        project.addElement("version").setText("1.0");

        // 创建parent元素并添加子元素
        Element parent = project.addElement("parent");
        parent.addElement("groupId").setText("org.springframework.boot");
        parent.addElement("artifactId").setText("spring-boot-starter-parent");
        parent.addElement("version").setText(pomAttribute.getSpringbootVersion()); //"2.3.6.RELEASE"
        parent.addElement("relativePath").setText(""); //"2.3.6.RELEASE"


        // 创建properties元素并添加子元素
        Element properties = project.addElement("properties");
        properties.addElement("maven.compiler.source").setText("8");
        properties.addElement("maven.compiler.target").setText("8");
        properties.addElement("project.build.sourceEncoding").setText("UTF-8");
        properties.addElement("java.version").setText("1.8");

        // 创建modules元素并添加子元素
        addNodesForOther(module);

        // 创建dependencies元素并添加子元素
        addNodes(dependencyList);


        // 创建build元素并添加子元素
        Element build = project.addElement("build");
        build.addElement("finalName").setText(pomAttribute.getArtifactId());

        // 输出XML文件
        refreshPom();
    }


    /**
     * 获取单个节点
     * @param key 标签名称
     * @return 节点值
     */
    public static String getSingleValue(String key) {
        Element element = document.getRootElement();
        return element.element(key).getStringValue();
    }

    /**
     * 添加 dependencies节点
     */
    @SneakyThrows
    public static void addNodes(List<Dependency> dependencyList) {
        if(dependencyList != null){
            for (Dependency dependency : dependencyList) {
                Element parentElement = null;
                // 设置默认命名空间
                Namespace namespace = Namespace.get(URL);

                // 创建XPath对象
                XPath xpath = DocumentHelper.createXPath("/ns:project/ns:"+dependency.getParentNodeName());
                xpath.setNamespaceURIs(Collections.singletonMap("ns", namespace.getURI()));

                // 获取第一个
                Element dependencies = (Element) xpath.selectSingleNode(document);
                if(dependencies == null){
                    // 创建XPath对象
                    XPath xpathProject = DocumentHelper.createXPath("/ns:project");
//                    XPath xpathProject = DocumentHelper.createXPath("/ns:project[not(@xmlns:p)]");
                    xpathProject.setNamespaceURIs(Collections.singletonMap("ns", namespace.getURI()));
                    // 获取第一个
                    Element project = (Element) xpathProject.selectSingleNode(document);
                    // 创建dependencies元素并添加子元素
                    dependencies = project.addElement("dependencies");
                    addDependencie(dependencies,dependency);
                }else{
                    addDependencie(dependencies,dependency);
                }
            }
        }

    }


    public static void addDependencie( Element dependencies,Dependency dependency) throws IOException {
        Element dependencyElement = dependencies.addElement("dependency");
        dependencyElement.addElement(DependencyConst.GROUPID.getTabName()).setText(dependency.getGroupId());
        dependencyElement.addElement(DependencyConst.ARTIFACTID.getTabName()).setText(dependency.getArtifactId());
        if (dependency.getVersion() != null) {
            dependencyElement.addElement(DependencyConst.VERSION.getTabName()).setText(dependency.getVersion());
        }
        System.out.println("添加成功");
        refreshPom();
    }


    /**
     * 添加Module节点 或者其他节点
     */
    public static void addNodesForOther(Module module) throws DocumentException, IOException {

        if(module != null){
            // 设置默认命名空间
            Namespace namespace = Namespace.get(URL);

            // 创建XPath对象
            XPath xpath = DocumentHelper.createXPath("/ns:project/ns:"+module.getParentNode());
            xpath.setNamespaceURIs(Collections.singletonMap("ns", namespace.getURI()));

            Element modules = (Element) xpath.selectSingleNode(document);
            if(modules == null){ //说明还没有这个 modules
                // 创建XPath对象
                XPath xpathProject = DocumentHelper.createXPath("/ns:project");
//                XPath xpathProject = DocumentHelper.createXPath("/ns:project[not(@xmlns:p)]");
                xpathProject.setNamespaceURIs(Collections.singletonMap("ns", namespace.getURI()));
                // 获取第一个
                Element project = (Element) xpathProject.selectSingleNode(document);
                // 创建dependencies元素并添加子元素
                modules = project.addElement(module.getParentNode());
                modules.addElement(DependencyConst.MODULE.getTabName()).setText(module.getModule());
                refreshPom(); //刷新
            }else{
                modules.addElement(DependencyConst.MODULE.getTabName()).setText(module.getModule());
                refreshPom();  //刷新
            }
        }

    }


    /**
     * 添加其他节点
     * @param otherNode
     * @throws DocumentException
     * @throws IOException
     */
    public static void addOtherNodes(OtherNode otherNode) throws DocumentException, IOException {

        if(otherNode != null){
            // 设置默认命名空间
            Namespace namespace = Namespace.get(URL);

            // 创建XPath对象
            XPath xpath = DocumentHelper.createXPath("/ns:project/ns:"+otherNode.getParentNodeName());
            xpath.setNamespaceURIs(Collections.singletonMap("ns", namespace.getURI()));

            Element node = (Element) xpath.selectSingleNode(document);
            if(node == null){ //说明还没有这个 modules
                // 创建XPath对象
                XPath xpathProject = DocumentHelper.createXPath("/ns:project");
//                XPath xpathProject = DocumentHelper.createXPath("/ns:project[not(@xmlns:p)]");
                xpathProject.setNamespaceURIs(Collections.singletonMap("ns", namespace.getURI()));
                // 获取第一个
                Element project = (Element) xpathProject.selectSingleNode(document);
                // 创建dependencies元素并添加子元素
                node = project.addElement(otherNode.getParentNodeName());

                for (OtherNode.Node otherNodeNode : otherNode.getNodes()) {
                    node.addElement(otherNodeNode.getNodeName()).setText(otherNodeNode.getContext());
                }
                refreshPom(); //刷新
            }else{

                for (OtherNode.Node otherNodeNode : otherNode.getNodes()) {
                    node.addElement(otherNodeNode.getNodeName()).setText(otherNodeNode.getContext());
                }

                refreshPom();  //刷新
            }
        }

    }


    /**
     * 刷新pom
     */
    public static void refreshPom() throws IOException {
        // 创建XMLWriter对象，并设置输出格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setIndent("    "); // 设置缩进为4个空格
        format.setNewlines(true); // 设置换行符
        XMLWriter writer = new XMLWriter(new FileWriter(pomFile), format);

        // 输出到文件
        writer.write(document);
        writer.close();

        System.out.println("XML文件刷新成功！");
    }
}
