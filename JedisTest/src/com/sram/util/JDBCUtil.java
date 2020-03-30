package com.sram.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 连接数据库的工具类
 */
public class JDBCUtil {

    private static String url;
    private static String username;
    private static String password;

    static{
        try {

            Properties properties = new Properties();

            properties.load(JDBCUtil.class.getResourceAsStream("/jdbc.properties"));

            String driver = properties.getProperty("driver");

            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url,username,password);
        return conn;
    }

    public static void close(Connection conn){
        try {
            if(conn !=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
