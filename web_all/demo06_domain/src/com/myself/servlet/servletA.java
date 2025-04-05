package com.myself.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/29 14:37
 */
@WebServlet("/servletA")

public class servletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求域
        req.setAttribute("请求域", "请求域属性");

        //会话域
        HttpSession session = req.getSession();
        session.setAttribute("会话域", "会话域属性");

        //应用域
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("应用域", "应用域属性");


//        System.out.println(req.getAttribute("请求域"));
//
//
//        System.out.println(session.getAttribute("会话域"));
//
//
//        System.out.println(servletContext.getAttribute("应用域"));

        req.getRequestDispatcher("servletB").forward(req,resp);

    }
}
