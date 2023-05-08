package com.yszhdhy.generator.construct.structure.database;


import com.yszhdhy.generator.constant.code.sql.*;
import com.yszhdhy.generator.constant.yaml.MyBatisPlusYamlConst;
import com.yszhdhy.generator.utils.database.TestConnection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuilderSql {

    public static void construct(String dbUrl,String port, String userName, String dbPassword, String dbName){
        create(dbUrl,port,userName,dbPassword,dbName);

        //修改mybatis中配置
        MyBatisPlusYamlConst.USERNAME.setDefaultValue(userName);
        MyBatisPlusYamlConst.PASSWORD.setDefaultValue(dbPassword);
        MyBatisPlusYamlConst.URL.setDefaultValue("jdbc:mysql://"+dbUrl+":"+port+"/"+dbName+"?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
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
