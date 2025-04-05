package com.myself.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/30 14:00
 */
@WebListener
public class MyApplicationListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println(servletContext.hashCode() +"应用域初始化");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println(servletContext.hashCode() +"应用域销毁");


    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        ServletContext servletContext = scae.getServletContext();
        System.out.println(servletContext.hashCode() +"应用域添加");

        System.out.println("增加内容为"+ scae.getName()+":"+scae.getValue());

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        ServletContext servletContext = scae.getServletContext();
        System.out.println(servletContext.hashCode() +"应用域移除");
        System.out.println("移除内容为"+ scae.getName()+":"+scae.getValue());

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        ServletContext servletContext = scae.getServletContext();
        System.out.println(servletContext.hashCode() +"应用域改变");
        System.out.println("修改内容为"+ scae.getName()+":"+scae.getValue() +"为"+servletContext.getAttribute("key1"));

    }
}
