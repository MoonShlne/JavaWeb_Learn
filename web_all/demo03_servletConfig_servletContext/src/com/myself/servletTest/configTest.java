package com.myself.servletTest;

import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/17 14:30
 */
@WebServlet("/servlet1")
public class configTest  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
//        String upload = servletContext.getRealPath("upload");
//        System.out.println(upload);
        servletContext.setAttribute("key","valuuuue");





    }
}
