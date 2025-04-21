package com.mysql.headline.controller;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:14
 */
import com.mysql.headline.common.Result;
import com.mysql.headline.common.ResultCodeEnum;
import com.mysql.headline.pojo.NewsHeadline;
import com.mysql.headline.service.impl.NewsHeadlineServiceImpl;
import com.mysql.headline.util.JwtHelper;
import com.mysql.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/headline/*")
public class NewsHeadlineController extends BaseController {
private  final NewsHeadlineServiceImpl headlineService = new NewsHeadlineServiceImpl();

    /**
     *从前端从请求的的token 以及json串
     * 把json串的内容放到数据库
     *
     */
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取json信息
        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        //根据token获取发布者ID
        Long userId = JwtHelper.getUserId(req.getHeader("token"));
        //把id赋值给 json传来的数据中
        newsHeadline.setPublisher(userId.intValue());
        //传入数据库
        Integer row =  headlineService.addNewHeadline(newsHeadline);

        //返回状态码
        WebUtil.writeJson(resp, Result.ok(null));
    }

    /**
     *通过请求参数的hid
     * 相应特定数据
     */
        protected void findHeadlineByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //获取hid
            String hid = req.getParameter("hid");

            //查询数据
            NewsHeadline newsHeadline= headlineService.findHeadlineByHid(hid);

            //把对象作为map返回
            HashMap<Object, Object> data = new HashMap<>();
            data.put("headline",newsHeadline);

            WebUtil.writeJson(resp,Result.ok(data));

        }

    //接收客户端json串，更新数据库
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收数据
        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        //更新
        Integer row = headlineService.updateHeadline(newsHeadline);
    }

    //接收hid  删除对应数据
    protected void removeByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hid = req.getParameter("hid");

        Integer row =  headlineService.deleteHeadline(hid);
        Result<Object> result = Result.ok(null);
        if (row==0){
        result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        }
        WebUtil.writeJson(resp,result);
    }
}


