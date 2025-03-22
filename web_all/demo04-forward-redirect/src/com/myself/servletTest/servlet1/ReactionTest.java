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
 * @since 2025/3/21 18:45
 */
@WebServlet("/reaction")
public class ReactionTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("GBK");  不推荐
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("中文乱码吗");
    }
}
