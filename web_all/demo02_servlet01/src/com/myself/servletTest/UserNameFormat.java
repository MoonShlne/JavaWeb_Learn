package com.myself.servletTest;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/15 15:04
 */
public class UserNameFormat extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String info ="UserName is Available";

        if (userName.equals("admin")||userName.equals("root")){
            info="already exist";
        }
        resp.setHeader("Content-Type","text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(info);

    }
}
