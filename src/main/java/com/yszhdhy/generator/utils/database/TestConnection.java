package com.yszhdhy.generator.utils.database;

import com.yszhdhy.generator.constant.code.sql.User;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class TestConnection {

    public static void main(String[] args) {
//        testConnection("jdbc:mysql://localhost:3306/","root","123456","ceshi");
    }

    /**
     * 判断数据库是否存在
     * @param url
     * @param username
     * @param password
     * @param databaseName
     * @return
     */
    public static boolean databaseExists(String url, String username, String password, String databaseName) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + databaseName + "'");
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 测试 连接数据库
     * @param dbUrl
     * @param userName
     * @param dbPassword
     * @param dbName
     */
    public static void testConnection(String dbUrl, String userName, String dbPassword, String dbName, List<String> createTableSqlList, List<String> insertDataSqlList ){

        // 设置数据库连接
        String url = dbUrl+dbName;
        String user = userName;
        String password = dbPassword;



        Connection conn = null;
        try {
            // 加载 JDBC 驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("数据库连接成功建立！");

            Statement stmt = conn.createStatement();

            if (databaseExists(dbUrl, user, password, dbName)) {
                System.out.println("Database" + dbName + "exists"+"开始创建表");

            } else {
                System.out.println("Database" + dbName + "does not exist"+"开始创建数据库");
                String createDbSql = "CREATE DATABASE " + dbName;

                //创建数据库
                stmt.executeUpdate(createDbSql);
                System.out.println("Database " + dbName + " created successfully!");

            }


            conn = DriverManager.getConnection(dbUrl+dbName, user, password);
            System.out.println("数据库重新连接成功建立！");
            stmt = conn.createStatement();

            for (String createTableSql : createTableSqlList) {
                //创建表
                createTable(stmt,createTableSql);
            }

            for (String insertDataSql : insertDataSqlList) {
                //插入数据
                insertData(stmt,insertDataSql);
            }


        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 驱动程序未找到");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
    }


    /**
     * 创建表
     * @param stmt
     * @param sql
     * @throws SQLException
     */
    public static void createTable(Statement stmt, String sql) throws SQLException {

        stmt.executeUpdate(sql);
        System.out.println("Table user created successfully!");
    }

    public static void insertData(Statement stmt, String sql) throws SQLException {
        stmt.executeUpdate(sql);
        System.out.println("Table user insert successfully!");
    }


}
