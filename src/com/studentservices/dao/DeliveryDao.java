package com.studentservices.dao;

import com.studentservices.entity.Delivery;
import com.studentservices.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryDao {
    /*public boolean query(Delivery kuaidi)
    {
        Connection connection = DBUtils.getConnection();
        String sql = "select * from 快递订单表 where name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,kuaidi.getName());
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
    }*/

    public boolean add(Delivery kuaidi)
    {
        Connection connection = DBUtils.getConnection();
        String sql = "insert into 快递订单表(快递订单编号,name,详细信息,完成标志) values(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,kuaidi.getId());
            preparedStatement.setString(2,kuaidi.getName());
            preparedStatement.setString(3, kuaidi.getInfo());
            preparedStatement.setString(4,kuaidi.getConfirm());
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
