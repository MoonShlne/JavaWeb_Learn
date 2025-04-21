package com.mysql.headline.filter;

import com.alibaba.druid.sql.parser.Token;
import com.mysql.headline.common.Result;
import com.mysql.headline.common.ResultCodeEnum;
import com.mysql.headline.util.JwtHelper;
import com.mysql.headline.util.WebUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/20 19:20
 */
@WebFilter("/headline/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse  resp= (HttpServletResponse) servletResponse;
        String token = req.getHeader("token");
        Result<Object> result = Result.build(null, ResultCodeEnum.NOTLOGIN);

        //如果过期
        if (JwtHelper.isExpiration(token)){
            WebUtil.writeJson(resp,result);
        }
        else {
           filterChain.doFilter(servletRequest,servletResponse);
        }


    }
}
