package com.myself.schedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myself.schedule.common.Result;
import com.myself.schedule.common.ResultCodeEnum;
import com.myself.schedule.pojo.SysUser;
import com.myself.schedule.service.impl.SysUserServiceImpl;
import com.myself.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/26 16:07
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {
    private final SysUserServiceImpl userService = new SysUserServiceImpl();

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
        SysUser sysUser = new SysUser(null, userName, userPassword);
        int flag = userService.register(sysUser);
        if (flag > 0) {
            resp.sendRedirect("/registSuccess.html");

        } else {
            resp.sendRedirect("/registFail.html");
        }


    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 接受参数
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");

        //2 调用方法
        SysUser sysUser = new SysUser(null, userName, userPassword);
        boolean flagUserName = userService.findUserName(sysUser);


        if (flagUserName) {
            boolean flagPassword = userService.findPassword(sysUser);
            if (!flagPassword) {
                resp.sendRedirect("/loginUserPwdError.html");
            } else {
                //将登陆的信息放入session域
                HttpSession session = req.getSession();
                session.setAttribute("sysUser", sysUser);

                resp.sendRedirect("/showSchedule.html");
            }
        } else {
            resp.sendRedirect("/loginUserNameError.html");
        }

    }

    /**
     * 再注册时，检验用户名是否被占用
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("username");
        boolean userName = userService.findUserName(new SysUser(null, parameter, null));

        Result result = Result.ok(null);

        if (userName) {  //在数据库中找到存在的用户名
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp, result);


    }

}
