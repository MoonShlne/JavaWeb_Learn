package com.myself.servletTest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.stream.events.EntityReference;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/17 15:05
 */

@WebServlet("/servlet4")
public class RequestApiTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

 //请求行  get post url 协议
        System.out.println(req.getMethod());   //请求方是
        System.out.println(req.getScheme());   //请求协议
        System.out.println(req.getProtocol());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());


        System.out.println(req.getLocalPort()); //应用的容器端口
        System.out.println(req.getServerPort()); //客户端发请求的端口号
        System.out.println(req.getRemotePort()); //客户端软件的端口号
//请求头  ket value
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            System.out.println(headerNames.nextElement());
        }


//请求体
    }




}
