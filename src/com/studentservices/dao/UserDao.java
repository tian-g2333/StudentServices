package com.studentservices.dao;

import com.studentservices.entity.User;
import com.studentservices.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDao {
    public boolean query(User user)
    {
        Connection connection = DBUtils.getConnection();
        String sql = "select * from 学生用户表 where name = ? and password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally {
            DBUtils.closeConnection();
        }
    }

    public boolean add(User user)
    {
        Connection connection = DBUtils.getConnection();
        String sql = "insert into 学生用户表(name,password,phone,registerTime) values(?,?,?,?)";

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(date);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4,dateStr);
            preparedStatement.executeUpdate();
            return preparedStatement.getUpdateCount() != 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally {
            DBUtils.closeConnection();
        }
    }
}

