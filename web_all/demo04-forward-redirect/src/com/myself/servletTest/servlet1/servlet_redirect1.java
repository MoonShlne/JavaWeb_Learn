package com.myself.servletTest.servlet1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/19 16:02
 */
@WebServlet("/servlet_redirect1")
public class servlet_redirect1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("s1执行");

        resp.sendRedirect("servlet_redirect2");
    }
}
