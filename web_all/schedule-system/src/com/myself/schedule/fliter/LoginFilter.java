package com.myself.schedule.fliter;

import com.myself.schedule.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/30 15:43
 */
@WebFilter(urlPatterns = {"/showSchedule.html","/schedule/*"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest  httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpServletRequest.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("sysUser");
        if (sysUser!=null){
        filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            httpServletResponse.sendRedirect("/login.html");
        }


    }
}
