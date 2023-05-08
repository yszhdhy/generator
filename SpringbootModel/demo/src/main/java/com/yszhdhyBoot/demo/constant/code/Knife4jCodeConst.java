package com.yszhdhyBoot.demo.constant.code;//package com.yszhdhy.generator.constant.code;
//
//import cloud.makeronbean.generate.resolver.PomResolver;
//
///**
// * @author makeronbean
// * @createDate 2023-05-01  21:01
// * @description
// */
//@SuppressWarnings("all")
//public enum Knife4jCodeConst implements CodeTemplate {
//    KNIFE4J_CONFIG("config/knife4j", "Knife4jConfiguration.java", "%s\n\n" +
//            "import org.springframework.beans.factory.annotation.Value;\n" +
//            "import org.springframework.context.annotation.Bean;\n" +
//            "import org.springframework.context.annotation.Configuration;\n" +
//            "import springfox.documentation.builders.ApiInfoBuilder;\n" +
//            "import springfox.documentation.builders.PathSelectors;\n" +
//            "import springfox.documentation.builders.RequestHandlerSelectors;\n" +
//            "import springfox.documentation.spi.DocumentationType;\n" +
//            "import springfox.documentation.spring.web.plugins.Docket;\n" +
//            "import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;\n" +
//            "\n" +
//            "\n" +
//            "@Configuration\n" +
//            "@EnableSwagger2WebMvc\n" +
//            "public class Knife4jConfiguration {\n" +
//            "    \n" +
//            "    @Bean(value = \"defaultApi2\")\n" +
//            "    public Docket defaultApi2() {\n" +
//            "        return new Docket(DocumentationType.SWAGGER_2)\n" +
//            "                .apiInfo(new ApiInfoBuilder()\n" +
//            "                        .title(\"swagger-bootstrap-ui-demo RESTful APIs\")\n" +
//            "                        .description(\"# swagger-bootstrap-ui-demo RESTful APIs\")\n" +
//            "                        .build())\n" +
//            "                //分组名称\n" +
//            "                .select()\n" +
//            "                //这里指定Controller扫描包路径\n" +
//            "                .apis(RequestHandlerSelectors.basePackage(\"" + PomResolver.getInstance().getGroupId() + ".controller\"))\n" +
//            "                .paths(PathSelectors.any())\n" +
//            "                .build();\n" +
//            "    }\n" +
//            "}"),
//
//    ;
//    private final String path;
//    private final String fileName;
//    private final String codeTemplate;
//
//    Knife4jCodeConst(String path, String fileName, String codeTemplate) {
//        this.path = path;
//        this.fileName = fileName;
//        this.codeTemplate = codeTemplate;
//    }
//
//    @Override
//    public String getPath() {
//        return path;
//    }
//
//    @Override
//    public String getFileName() {
//        return fileName;
//    }
//
//    @Override
//    public String getCodeTemplate() {
//        return codeTemplate;
//    }
//}
