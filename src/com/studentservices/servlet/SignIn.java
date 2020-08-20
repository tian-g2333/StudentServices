package com.studentservices.servlet;

import com.studentservices.dao.UserDao;
import com.studentservices.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException,ServletException
    {
        this.doPost(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException, ServletException
    {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/plain;charset=utf-8");//设置相应类型为html,编码为utf-8

        String name = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");

        UserDao userDao = new UserDao();
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        if(!userDao.query(user))//若查询失败
        {
            httpServletResponse.sendError(204,"query failed.");//设置204错误码与出错信息
        }
    }
}