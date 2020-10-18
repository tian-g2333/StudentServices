package com.studentservices.servlet;

import com.studentservices.dao.DeliveryDao;
import com.studentservices.entity.Delivery;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeliveryAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException
    {
        this.doPost(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException
    {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");//设定编码防止中文乱码
        httpServletResponse.setContentType("text/plain;charset=utf-8");//设置相应类型为html,编码为utf-8

        String name = httpServletRequest.getParameter("name");//根据name获取参数
        String info = httpServletRequest.getParameter("info");//根据info获取参数
        String confirm = "未完成";
        String id = "123456";

        DeliveryDao deliveryDao = new DeliveryDao();
        Delivery delivery = new Delivery();
        delivery.setId(id);
        delivery.setName(name);
        delivery.setInfo(info);
        delivery.setConfirm(confirm);

        if(!deliveryDao.add(delivery)) //若添加失败
        {
            httpServletResponse.sendError(204,"add failed.");//设置204错误码与出错信息
        }
    }
}
