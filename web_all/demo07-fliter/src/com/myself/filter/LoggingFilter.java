package com.myself.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/29 15:36
 */
public class LoggingFilter implements Filter {
       private  SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
  /*
  1 先判断是否满足条件

  2，放行

  3
   */

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();

        String format = simpleDateFormat.format(new Date());

        String beforeLogging =requestURI+"在"+format +"被访问了";
        System.out.println(beforeLogging);
        long l1 = System.currentTimeMillis();


        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        long l2 = System.currentTimeMillis();
        String afterLogging =requestURI+"在"+format +"的请求耗时（毫秒数）为"+(l2-l1);
        System.out.println(afterLogging);

    }
}
