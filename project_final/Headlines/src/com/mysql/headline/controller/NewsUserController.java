package com.mysql.headline.controller;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:14
 */

import com.mysql.headline.common.Result;
import com.mysql.headline.common.ResultCodeEnum;
import com.mysql.headline.pojo.NewsType;
import com.mysql.headline.pojo.NewsUser;
import com.mysql.headline.service.impl.NewsUserServiceImpl;
import com.mysql.headline.util.JwtHelper;
import com.mysql.headline.util.MD5Util;
import com.mysql.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/user/*")
public class NewsUserController extends BaseController {
    private final NewsUserServiceImpl userService = new NewsUserServiceImpl();

    /**
     * 客户端传来post请求，包含账号和密码的json串
     * 数据库校验后返回不同校验码的result对象
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受json 实例化对象
        NewsUser newsUser = WebUtil.readJson(req, NewsUser.class);
        //调用service层方法返回查询结果对象
        NewsUser loginUser = userService.findUser(newsUser);
        Result<Object> resulet = null;
        if (loginUser == null) {
            //返回空对象 =>用户名不存在
            resulet = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        } else {
            //用户名存在
            if (loginUser.getUserPwd().equals(MD5Util.encrypt(newsUser.getUserPwd()))) {
                //密码相同，登录成功，返回token,以及状态码,两者封装在一个result
                String token = JwtHelper.createToken(Long.valueOf(loginUser.getUid()));
                HashMap<Object, Object> data = new HashMap<>();
                data.put("token", token);
                resulet = Result.ok(data);
            } else {
                //密码错误
                resulet = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            }

        }
        WebUtil.writeJson(resp, resulet);

    }

    /**
     * 前端以请求头的方式返回一个token
     * 根据token 判断是否存在以及是否过期， 返回相应的状态码以及 该token的对象信息（不包含密码）
     */
    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取token
        String token = req.getHeader("token");
        Result<Object> result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        //判断token是否过期或者是否存在
        if (token != null && !token.isEmpty()) {
            //判断token是否过期
            if (!JwtHelper.isExpiration(token)) {
                //如果没过期就解析uid
                int uid = JwtHelper.getUserId(token).intValue();
                NewsUser user = userService.findByUid(uid);
                if (user != null) {
                    //返回查询到的用户信息，放到result返回
                    HashMap<Object, Object> data = new HashMap<>();
                    user.setUserPwd("");
                    data.put("loginUser", user);
                    result = Result.ok(data);
                }

            }

        }
        WebUtil.writeJson(resp, result);

    }

    /**
     * 用户以post请求传来一个用户名
     * 检验用户名是否存在
     * 返回result对象
     */
    protected void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post的请求值
        String username = req.getParameter("username");

        //在数据库查询该用户的用户名是否存在
        NewsUser user = userService.findByUserName(username);
        Result<Object> result = Result.ok(null);
        if (user != null) {
            //用户名已占用
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        //返回result给前端
        WebUtil.writeJson(resp, result);
    }

    /**
     * 接收前端返回的json串，将新用户数据保存到数据库
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受前端json
        NewsUser user = WebUtil.readJson(req, NewsUser.class);

        //将user的密码加密储存到数据库
        Integer rows = userService.addNewUser(user);
        Result<Object> result = Result.ok(null);
        if (rows ==0){
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }


    protected void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Result<Object> result = Result.ok(null);
        if (JwtHelper.isExpiration(token)){
            result= Result.build(null,ResultCodeEnum.NOTLOGIN);
        }
        WebUtil.writeJson(resp,result);

    }
}




