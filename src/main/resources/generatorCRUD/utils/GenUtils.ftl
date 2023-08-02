package ${packageName};

import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.utils.SystemUtils;
import ${packageNameModel}.model.SysMenu;
import ${packageNameEntity}.entity.ColumnEntity;
import ${packageNameEntity}.entity.TableEntity;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class GenUtils {

    private static String currentTableName;

    //封装模板数据
    static private Map<String, Object> map = new HashMap<>();
    static private Map<String, Object> getTemplatesMap = new HashMap<>();

    public static List<String> getTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("template/Entity.java.vm");
        templates.add("template/Dao.xml.vm");


        templates.add("template/Service.java.vm");
        templates.add("template/ServiceImpl.java.vm");
        templates.add("template/Controller.java.vm");
        templates.add("template/Dao.java.vm");

        templates.add("template/index.vue.vm");
        templates.add("template/add-or-update.vue.vm");
        templates.add("template/Vue3index.vue.vm");

        return templates;
    }

    public static void getGetTemplatesMap( String IndexPath,String addOrUpdatePath, String vue3IndexPath){
       getTemplatesMap.put("template/Entity.java.vm",PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ map.get("EntityPackage"));
       getTemplatesMap.put("template/Dao.xml.vm",PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ map.get("DaoXmlPackage"));
       getTemplatesMap.put("template/Service.java.vm",PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ map.get("ServicePackage"));
       getTemplatesMap.put("template/ServiceImpl.java.vm",PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ map.get("ServiceImplPackage"));
       getTemplatesMap.put("template/Controller.java.vm",PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ map.get("controllerPackage"));
       getTemplatesMap.put("template/Dao.java.vm",PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ map.get("DaoPackage"));
       getTemplatesMap.put("template/index.vue.vm",SystemUtils.getProjectPath()+IndexPath);
       getTemplatesMap.put("template/add-or-update.vue.vm",SystemUtils.getProjectPath()+addOrUpdatePath);
       getTemplatesMap.put("template/Vue3index.vue.vm",SystemUtils.getProjectPath()+vue3IndexPath);
    }

    public static List<String> getMongoChildTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("template/MongoChildrenEntity.java.vm");
        return templates;
    }

    /**
     * 生成代码
     */
    public static void generatorCode(Map<String, String> table,
                                     List<Map<String, String>> columns, ZipOutputStream zip,String component,SysMenu sysMenu) throws IOException {
        //配置信息
        Configuration config = getConfig();
        boolean hasBigDecimal = false;
        boolean hasList = false;
        //表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.get("tableName"));
        tableEntity.setComments(table.get("tableComment"));
        //表名转换成Java类名
        String className = tableToJava(tableEntity.getTableName(), config.getStringArray("tablePrefix"));
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));

        //列信息
        List<ColumnEntity> columsList = new ArrayList<>();
        String columnNames = "";
        for (Map<String, String> column : columns) {
           if(StringUtils.isEmpty(column.get("columnComment"))){
                column.put("columnComment",column.get("columnName"));
            }
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(column.get("columnName"));
            columnEntity.setDataType(column.get("dataType"));
            columnEntity.setComments(column.get("columnComment"));
            columnEntity.setExtra(column.get("extra"));

            columnNames += column.get("columnName")+",";
            //列名转换成Java属性名
            String attrName = columnToJava(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAttrname(StringUtils.uncapitalize(attrName));

            //列的数据类型，转换成Java类型
            String attrType = config.getString(columnEntity.getDataType(), columnToJava(columnEntity.getDataType()));
            columnEntity.setAttrType(attrType);


            if (!hasBigDecimal && attrType.equals("BigDecimal")) {
                hasBigDecimal = true;
            }
            if (!hasList && "array".equals(columnEntity.getExtra())) {
                hasList = true;
            }
            //是否主键
            if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableEntity.getPk() == null) {
                tableEntity.setPk(columnEntity);
            }

            columsList.add(columnEntity);
        }
        tableEntity.setColumns(columsList);

        //没主键，则第一个字段为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);
        String mainPath = config.getString("mainPath");
        mainPath = StringUtils.isBlank(mainPath) ? "io.yszhdhy" : mainPath;

        map.put("columnNames", columnNames);
        map.put("dataForm", "this.dataForm.");
        map.put("tableName", tableEntity.getTableName());
        map.put("comments", tableEntity.getComments());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname().toLowerCase());
        map.put("columns", tableEntity.getColumns());
        map.put("hasBigDecimal", hasBigDecimal);
        map.put("hasList", hasList);
        map.put("mainPath", mainPath);
        map.put("package", config.getString("package"));
        map.put("moduleName", sysMenu.getModuleName());
        map.put("author", sysMenu.getAuthor());
        map.put("email", sysMenu.getEmail());
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));

        map.put("controllerPackage", (ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/controller").replaceAll("/","\\."));
        map.put("DaoPackage", (ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/mapper").replaceAll("/","\\."));
        map.put("DaoXmlPackage", (ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/mapper/xml").replaceAll("/","\\."));
        map.put("EntityPackage", (ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/model").replaceAll("/","\\."));
        map.put("ServicePackage", (ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service").replaceAll("/","\\."));
        map.put("ServiceImplPackage", (ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service/impl").replaceAll("/","\\."));
        map.put("ResultPackage", (ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId()+"/result").replaceAll("/","\\."));

        VelocityContext context = new VelocityContext(map);
        // 文件存放路径初始化
        getGetTemplatesMap("/vue/src/views/"+component,"/vue/src/views/"+component,"/vue3/src/views/"+component);

        //获取模板列表
        List<String> templates = getTemplates();
        for (String template : templates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);

        if (sysMenu.getIsPack()==1){
            try {
                //添加到zip
                zip.putNextEntry(new ZipEntry(getFileName(template, tableEntity.getClassName(), config.getString("package"), config.getString("moduleName"))));
                IOUtils.write(sw.toString(), zip, "UTF-8");
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            } catch (IOException e) {
                throw new RRException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
            }
        }else{
              String o = (String) getTemplatesMap.get("template/index.vue.vm");
             File file1 = new File(o);
            file1.mkdir();
            String o1 = (String) getTemplatesMap.get("template/Vue3index.vue.vm");
            File file2 = new File(o1);
            file2.mkdir();

            String content = sw.toString(); // 将渲染后的内容转换为字符串
            String filename = getFileName(template, tableEntity.getClassName(), config.getString("package"), config.getString("moduleName")); // 输出文件的名称
//          File file = new File((System.getProperty("user.dir") +"/demo"+ template.replaceAll("\\.vm","")).replace("/template",""));
            String s = getTemplatesMap.get(template).toString().replace(".", "/") + "/";
            String replace2 = "";

            if(template.contains("index.vue.vm")){
               if(new File(SystemUtils.getProjectPath()+"/vue").exists()&&!template.contains("Vue3")){
                  replace2 = (s + template).replaceAll("\\.vm", "").replace("/template/", "/" + map.get("className"));
               }else if(new File(SystemUtils.getProjectPath()+"/vue3").exists()){
                  replace2 = s + map.get("className") + "index.vue";
               }else {
                  continue;
               }
            }else {
               replace2 = (s + template).replaceAll("\\.vm", "").replace("/template/", "/" + map.get("className"));
            }

            File file = new File(replace2);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);

            bw.close();
            fw.close();
        }
        }
    }



    /**
     * 列名转换成Java属性名
     */
    public static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 表名转换成Java类名
     */
    public static String tableToJava(String tableName, String[] tablePrefixArray) {
        if (null != tablePrefixArray && tablePrefixArray.length > 0) {
            for (String tablePrefix : tablePrefixArray) {
                  if (tableName.startsWith(tablePrefix)){
                    tableName = tableName.replaceFirst(tablePrefix, "");
                }
            }
        }
        return columnToJava(tableName);
    }

    /**
     * 获取配置信息
     */
    public static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("template/generator.properties");
        } catch (ConfigurationException e) {
            throw new RRException("获取配置文件失败，", e);
        }
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String template, String className, String packageName, String moduleName) {
        String packagePath = "main" + File.separator + "java" + File.separator;
        if (StringUtils.isNotBlank(packageName)) {
            packagePath += packageName.replace(".", File.separator) + File.separator + moduleName + File.separator;
        }
        if (template.contains("MongoChildrenEntity.java.vm")) {
            return packagePath + "entity" + File.separator + "inner" + File.separator + currentTableName+ File.separator + splitInnerName(className)+ "InnerEntity.java";
        }
        if (template.contains("Entity.java.vm") || template.contains("MongoEntity.java.vm")) {
            return packagePath + "entity" + File.separator + className + "Entity.java";
        }

        if (template.contains("Dao.java.vm")) {
            return packagePath + "dao" + File.separator + className + "Dao.java";
        }

        if (template.contains("Service.java.vm")) {
            return packagePath + "service" + File.separator + className + "Service.java";
        }

        if (template.contains("ServiceImpl.java.vm")) {
            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }

        if (template.contains("Controller.java.vm")) {
            return packagePath + "controller" + File.separator + className + "Controller.java";
        }

        if (template.contains("Dao.xml.vm")) {
            return "main" + File.separator + "resources" + File.separator + "mapper" + File.separator + moduleName + File.separator + className + "Dao.xml";
        }

        if (template.replaceAll("template/","").equals("index.vue.vm")) {
            return "main" + File.separator + "resources" + File.separator + "src" + File.separator + "views" + File.separator + "modules" +
                    File.separator + moduleName + File.separator + className.toLowerCase() + ".vue";
        }

        if(template.replaceAll("template/","").equals("Vue3index.vue.vm")){
            return "main" + File.separator + "resources" + File.separator + "src" + File.separator + "views" + File.separator + "modules" +
                    File.separator + moduleName + File.separator + className.toLowerCase() + "Vue3.vue";
        }

        if (template.contains("add-or-update.vue.vm")) {
            return "main" + File.separator + "resources" + File.separator + "src" + File.separator + "views" + File.separator + "modules" +
                    File.separator + moduleName + File.separator + className.toLowerCase() + "-add-or-update.vue";
        }

        return null;
    }


    private static String splitInnerName(String name){
          name = name.replaceAll("\\.","_");
          return name;
    }

// 获取数据库中所有表名
public static List<String> getDatabaseTableNames() {

     // 读取 YAML 文件
     InputStream inputStream = GenUtils.class.getResourceAsStream("/application.yaml");
     //            FileInputStream inputStream = new FileInputStream(filePath);
     Yaml yaml = new Yaml();

     // 解析 YAML 文件
     Map<String, Object> data = yaml.load(inputStream);

     // 提取数据
     // 这里假设 YAML 文件的顶级元素是一个映射（Map）
     Map<String, Object> spring = (Map<String, Object>) data.get("spring");
     Map<String, Object> datasource = (Map<String, Object>) spring.get("datasource");

     System.out.println(datasource);

     String url = (String) datasource.get("url");
     String username = (String) datasource.get("username");
     String password = (String) datasource.get("password");

     // 打印提取的数据
     //        System.out.println("Value: " + url+username+password);


     List<String> tableNames = new ArrayList<>();

     try {
        // 连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

         // 执行查询语句获取表名
         String sql = "SHOW TABLES";
         ResultSet resultSet = statement.executeQuery(sql);

         // 提取表名
         while (resultSet.next()) {
            String tableName = resultSet.getString(1);
            tableNames.add(tableName);
         }

         // 关闭连接
         resultSet.close();
         statement.close();
         connection.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }

     return tableNames;
     }
}
