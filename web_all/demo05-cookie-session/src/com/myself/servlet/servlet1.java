package com.myself.servlet;

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
 * @since 2025/3/29 13:20
 * test session
 */@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受参数
        String parameter = req.getParameter("username");
        //获取session对象
        HttpSession session = req.getSession();


        System.out.println(session.getId());
        System.out.println(session.isNew());

        //储存属性
        session.setAttribute("username", parameter);
        //相应信息
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("成功");

    }
}
