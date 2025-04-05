package com.myself.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/29 18:51
 */
@WebFilter("/*")

public class Filter3 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before do 3");
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("after do 3");
    }
}
