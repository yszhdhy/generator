package com.yszhdhy.generator.construct.structure.database;


import com.yszhdhy.generator.constant.code.sql.*;
import com.yszhdhy.generator.constant.common.yaml.YamlPath;
import com.yszhdhy.generator.constant.yaml.MyBatisPlusYamlConst;
import com.yszhdhy.generator.utils.YamlDisposition;
import com.yszhdhy.generator.utils.database.TestConnection;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuilderSql {

    public static void construct(String dbUrl,String port, String userName, String dbPassword, String dbName) throws IOException {
        create(dbUrl,port,userName,dbPassword,dbName);

        //修改mybatis中配置
//        MyBatisPlusYamlConst.USERNAME.setDefaultValue(userName);
//        MyBatisPlusYamlConst.PASSWORD.setDefaultValue(dbPassword);
//        MyBatisPlusYamlConst.URL.setDefaultValue("jdbc:mysql://"+dbUrl+":"+port+"/"+dbName+"?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");


        System.out.println("文件删除成功");

        // 从YAML文件中加载数据到Java对象中
        InputStream input = new FileInputStream(new File(YamlPath.YAML_PATH.getYamlPath()));
        Yaml yaml = new Yaml();
        Object obj = yaml.load(input);

        Map<String, Object> map = null;
        // 修改Java对象中的某条消息
        // 假设我们要将message1的内容从"Hello"修改为"World"
        if (obj instanceof Map) {
            map = (Map<String, Object>) obj;
            Map<String, Object> message1 = (Map<String, Object>) map.get("spring");
            Map<String, Object> message2 = (Map<String, Object>) message1.get("datasource");
            message2.put("url", "jdbc:mysql://"+dbUrl+":"+port+"/"+dbName+"?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
            message2.put("password", dbPassword);
            message2.put("username", userName);


        }
        input.close();

        File file = new File(YamlPath.YAML_PATH.getYamlPath());
        boolean delete = file.delete();
        System.out.println(delete+"delenvksnng");
        if(delete){
            // 将修改后的Java对象写回YAML格式
            YamlDisposition.write(YamlPath.YAML_PATH.getYamlPath(),map);
        }


//        Writer output = new FileWriter(new File(YamlPath.YAML_PATH.getYamlPath()));
//        yaml.dump(obj, output);
    }


    public static void create(String dbUrl,String port, String userName, String dbPassword, String dbName){
        List<String> insertSqlList = builderInsertSql();
        List<String> createSqlList = builderCreateSql();
        TestConnection.testConnection("jdbc:mysql://"+dbUrl+":"+port+"/",
                userName,
                dbPassword,
                dbName,
                createSqlList,
                insertSqlList);
    }

    /**
     * 组建insert集合
     * @return
     */
    public static List<String> builderInsertSql(){
        ArrayList<String> insertSqlList = new ArrayList<>();
        insertSqlList.add(User.USER_TANLE.getInsertTableSql()); //user表中数据
        insertSqlList.add(Menu.MENU_TABLE.getInsertTableSql()); //user表中数据
        insertSqlList.add(Role.ROLE_TABLE.getInsertTableSql()); //user表中数据
        insertSqlList.add(Role_Menu.ROLE_MENU_TABLE.getInsertTableSql()); //user表中数据
        insertSqlList.add(User_Role.USER_ROLE_TABLE.getInsertTableSql()); //user表中数据

        return insertSqlList;
    }


    /**
     * 组建create集合
     * @return
     */
    public static List<String> builderCreateSql(){
        ArrayList<String> createSqlList = new ArrayList<>();
        createSqlList.add(User.USER_TANLE.getCreateTableSql()); //user表
        createSqlList.add(Menu.MENU_TABLE.getCreateTableSql()); //user表中数据
        createSqlList.add(Role.ROLE_TABLE.getCreateTableSql()); //user表中数据
        createSqlList.add(Role_Menu.ROLE_MENU_TABLE.getCreateTableSql()); //user表中数据
        createSqlList.add(User_Role.USER_ROLE_TABLE.getCreateTableSql()); //user表中数据

        return createSqlList;
    }

}
