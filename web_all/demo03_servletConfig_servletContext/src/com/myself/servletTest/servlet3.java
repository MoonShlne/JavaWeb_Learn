package com.myself.servletTest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/19 14:19
 */
@WebServlet("/servlet3")
public class servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getParameter("account"));
//        System.out.println(req.getParameter("password"));
////        System.out.println(req.getParameter("hobby"));
//
//        String[] hobbies = req.getParameterValues("hobby");
//        System.out.println(Arrays.toString(hobbies));





                //获得所有属性名
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()){
//            String s = parameterNames.nextElement();
////            用每个属性名获得属性值 以数组形式返回，所以用getvalues方法
//            String[] parameter = req.getParameterValues(s);
//
//            //判断返回是否是“数组” ，最终返回特定形式
//            if (parameter.length==1){
//                System.out.println(parameter[0]);
//            }
//            else {
//                System.out.println(s+"="+Arrays.toString(parameter));
//            }
//
//        }
//
//

        Map<String, String[]> parameterMap = req.getParameterMap();


    }
}
