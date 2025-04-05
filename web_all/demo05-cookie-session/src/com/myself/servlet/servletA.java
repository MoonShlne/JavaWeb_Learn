package com.myself.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/27 21:17
 */@WebServlet("/servletA")
public class servletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key", "value");
        Cookie cookie1 = new Cookie("key1", "value1");
        cookie1.setMaxAge(30);
        cookie.setPath("/servletB");
        resp.addCookie(cookie);
        resp.addCookie(cookie1);


    }
}
