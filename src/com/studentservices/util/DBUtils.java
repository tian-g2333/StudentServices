package com.studentservices.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static Connection connection = null;
    public static Connection getConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/学生生活服务系统?serverTimezone=UTC";
            String usename = "student";
            String password = "123456";
            connection = DriverManager.getConnection(url,usename,password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public static void closeConnection()
    {
        if(connection != null)
        {
            try {
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}

