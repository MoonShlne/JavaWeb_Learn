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
 * @since 2025/3/29 14:57
 */
@WebServlet("/servletB")
public class servletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getAttribute("请求域"));

        HttpSession session = req.getSession();
        System.out.println(session.getAttribute("会话域"));

        ServletContext servletContext = getServletContext();
        System.out.println(servletContext.getAttribute("应用域"));    }
}
