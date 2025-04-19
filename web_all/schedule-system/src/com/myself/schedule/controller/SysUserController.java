package com.myself.schedule.controller;

import com.myself.schedule.common.Result;
import com.myself.schedule.common.ResultCodeEnum;
import com.myself.schedule.pojo.SysUser;
import com.myself.schedule.service.impl.SysUserServiceImpl;
import com.myself.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

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
//        String userName = req.getParameter("userName");
//        String userPassword = req.getParameter("userPassword");

        SysUser sysUser = WebUtil.readJson(req, SysUser.class);
        //2 调用服务层方法
        int rows = userService.register(sysUser);

        Result result = Result.ok(null);

        if (rows < 1) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp, result);


    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 接受参数
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);
        //2 调用方法
        boolean flagUserName = userService.findUserName(sysUser);
        Result<Object> result = Result.ok(null);

        if (flagUserName) {
            //如果找到了name
            boolean flagPassword = userService.findPassword(sysUser);
            if (!flagPassword) {
                //没找到密码
                result= Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            } else {
                //账号密码正确，将属性传到前端作为路由守卫的条件
                SysUser loginUser = userService.findUser(sysUser);
                HashMap<Object, Object> data= new HashMap<>();
                loginUser.setPassword("");
                data.put("loginUser",loginUser);
                result= Result.ok(data);
                //密码正确
                //将登陆的信息放入session域
//                HttpSession session = req.getSession();
//                session.setAttribute("sysUser", sysUser);

            }
        } else {
            //没找到name
            result=  Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        WebUtil.writeJson(resp,result);


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
