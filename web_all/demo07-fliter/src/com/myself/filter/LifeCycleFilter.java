package com.myself.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/29 16:54
 */
public class LifeCycleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤咯");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
