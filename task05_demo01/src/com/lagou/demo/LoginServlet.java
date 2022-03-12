package com.lagou.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("获取到的姓名是:" + username + ",获取到的密码是:" + password);
        if (username.equals("admin")&&password.equals("123456")){
            System.out.println("登录成功");
            req.getSession().setAttribute("username",username);
            resp.sendRedirect("main.jsp");
        }else {
            System.out.println("登录失败,用户名或密码错误");
            resp.setContentType("text/html;charset=UTF-8");
            /*PrintWriter writer = resp.getWriter();
            writer.println("登录失败,用户名或密码错误");*/
            req.getSession().setAttribute("error","登录失败,用户名或密码错误");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
