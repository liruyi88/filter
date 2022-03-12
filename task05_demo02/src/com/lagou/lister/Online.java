package com.lagou.lister;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//监听servletContext上下文对象，监听session
public class Online implements HttpSessionListener, ServletContextListener {
    // 声明一个ServletContext类型的引用负责作为全局对象来记录当前在线用户的数量，通过属性记录
    private ServletContext servletContext = null;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //有一个用户上线  用户每次访问都初始化servlet上下文对象
        servletContext = servletContextEvent.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContext = null;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //有用户上线，获取上下文中的count属性，如果是空的说明是第一个用户，设置属性count，属性值为1保存到session中
        System.out.println("有新用户上线了。。。。");
        Object count = servletContext.getAttribute("count");
        if (count == null){
            httpSessionEvent.getSession().setAttribute("count",1);
        }else {
            //如果不是第一个用户，获取属性count的值加1在保存到session中
            Integer integer = (Integer) httpSessionEvent.getSession().getAttribute("count");
            integer++;
            httpSessionEvent.getSession().setAttribute("count",integer);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("有用户下线了");
        Integer count = (Integer) servletContext.getAttribute("count");
        count--;
        httpSessionEvent.getSession().setAttribute("count",count);
    }
}
