package com.myself.schedule.controller;

import com.myself.schedule.pojo.SysUser;
import com.myself.schedule.service.impl.SysUserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/26 16:07
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {
    /**
     * 接受注册业务的处理方法  （业务处理接口）
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 接受参数
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        //2 调用服务层方法
        SysUserServiceImpl sysUserService = new SysUserServiceImpl();
        SysUser sysUser = new SysUser(null, userName, userPassword);
        int flag = sysUserService.register(sysUser);
        if (flag>0) {
            resp.sendRedirect("/registSuccess.html");

        } else {
            resp.sendRedirect("/registFail.html");
        }


        //3 注册结果做页面跳转
    }


}
