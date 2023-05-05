package cloud.makeronbean.generate.resolver.FileBuilder.service.yaml;

import cloud.makeronbean.generate.constant.code.CodeTemplate;
import cloud.makeronbean.generate.constant.code.SpringParentCodeConst;
import cloud.makeronbean.generate.constant.common.ModuleGroupId;
import cloud.makeronbean.generate.entity.project.ProjectInfo;
import cloud.makeronbean.generate.resolver.FileBuilder.BuildTheFile;
import cloud.makeronbean.generate.utils.SystemUtils;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class YamlInitiate {

    public static void construct(ProjectInfo info) throws IOException {


        String filePath = info.getBaseGeneratePathForModuleGroupId(SystemUtils.getProjectPath(),
                "/"+new File(SystemUtils.getProjectPath()).getName(),
                ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId());

        // 创建Java对象并设置其属性：
        Map<String, Object> yamlData = new HashMap<>();
        yamlData.put("spring", new HashMap<String, Object>());
        yamlData.put("server", new HashMap<String, Object>());
        yamlData.put("mybatis-plus", new HashMap<String, Object>());



        Map<String, Object> spring = (Map<String, Object>) yamlData.get("spring");
        spring.put("application", new HashMap<String, Object>());
        spring.put("jackson", new HashMap<String, Object>());
        spring.put("mvc", new HashMap<String, Object>());
        spring.put("datasource", new HashMap<String, Object>());

        Map<String, Object> application = (Map<String, Object>) spring.get("application");
        application.put("name", "untitled");

        Map<String, Object> jackson = (Map<String, Object>) spring.get("jackson");
        jackson.put("date-format", "yyyy-MM-dd");
        jackson.put("time-zone", "Asia/Shanghai");

        Map<String, Object> mvc = (Map<String, Object>) spring.get("mvc");
        mvc.put("format", new HashMap<String, Object>());

        Map<String, Object> format = (Map<String, Object>) mvc.get("format");
        format.put("date", "yyyy-MM-dd");
        format.put("date-time", "yyyy-MM-dd HH:mm:ss");

        Map<String, Object> datasource = (Map<String, Object>) spring.get("datasource");
        datasource.put("password", "123456");
        datasource.put("driver-class-name", "com.mysql.cj.jdbc.Driver");
        datasource.put("url", "jdbc:mysql://localhost:3306/untitled?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        datasource.put("username", "root");

        Map<String, Object> server = (Map<String, Object>) yamlData.get("server");
        server.put("port", 8080);

        Map<String, Object> mybatisPlus = (Map<String, Object>) yamlData.get("mybatis-plus");
        mybatisPlus.put("configuration", new HashMap<String, Object>());
        mybatisPlus.put("global-config", new HashMap<String, Object>());

        Map<String, Object> configuration = (Map<String, Object>) mybatisPlus.get("configuration");
        configuration.put("log-impl", "org.apache.ibatis.logging.stdout.StdOutImpl");
        configuration.put("map-underscore-to-camel-case", true);

        Map<String, Object> globalConfig = (Map<String, Object>) mybatisPlus.get("global-config");
        globalConfig.put("db-config", new HashMap<String, Object>());

        Map<String, Object> dbConfig = (Map<String, Object>) globalConfig.get("db-config");
        dbConfig.put("logic-not-delete-value", 0);
        dbConfig.put("logic-delete-value", 1);
        dbConfig.put("logic-delete-field", "isDelete");

        globalConfig.put("type-aliases-package", "org.example.entity");


//        对文件的格式进行梳理
        /**
         * DumperOptions是SnakeYAML库中的一个类，用于设置和控制YAML输出的选项。通过使用DumperOptions，你可以自定义生成的YAML文档的格式和样式。
         */
        final DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setDefaultScalarStyle(DumperOptions.ScalarStyle.PLAIN);

//        将Java对象转换为YAML格式并写入文件：
        try (FileWriter writer = new FileWriter("data.yaml")) {
            Yaml yaml = new Yaml(options);
            yaml.dump(yamlData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
