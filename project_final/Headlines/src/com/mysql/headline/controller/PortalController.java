package com.mysql.headline.controller;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:14
 * 不需要登录的门户页请求
 */

import com.mysql.headline.common.Result;
import com.mysql.headline.pojo.NewsType;
import com.mysql.headline.pojo.vo.HeadlineDetailVo;
import com.mysql.headline.pojo.vo.HeadlineQueryVo;
import com.mysql.headline.service.impl.NewsHeadlineServiceImpl;
import com.mysql.headline.service.impl.NewsTypeServiceImpl;
import com.mysql.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.rmi.server.UID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/portal/*")
public class PortalController extends BaseController {
    private final NewsTypeServiceImpl typeService = new NewsTypeServiceImpl();
    private final NewsHeadlineServiceImpl headlineService = new NewsHeadlineServiceImpl();

    /**
     * 查询所有的头条类型，放入RESULT的DATA响应给刻骨的
     */
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //执行service层的查询语句
        List<NewsType> newsType = typeService.finAllTypes();
//        HashMap<Object, Object> data = new HashMap<>();
//        data.put("data",newsType);
        //创建result输出并且 返回newsType给客户端
        Result<List<NewsType>> result = Result.ok(newsType);
        WebUtil.writeJson(resp, result);

    }

    /**
     * 从前端所给的json串数据返回根据条件搜索分页信息,返回含页码数,页大小,总页数,总记录数,当前页数据等信息,并根据时间降序,浏览量降序排序
     */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受json数据
        HeadlineQueryVo headlineQueryVo = WebUtil.readJson(req, HeadlineQueryVo.class);
        //调用service层方法获取查询结果
        Map<String, Object> page = headlineService.findPage(headlineQueryVo);
        //返回值
        HashMap<Object, Object> data = new HashMap<>();
        data.put("pageInfo", page);
        WebUtil.writeJson(resp, Result.ok(data));
    }

    //接收前端参数 hid
    //响应特定格式数据
    protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String hid = req.getParameter("hid");
        HeadlineDetailVo detailVo= headlineService.findHeadlineDetail(hid);

        HashMap<Object, Object> data = new HashMap<>();
        data.put("headline",detailVo);
        WebUtil.writeJson(resp,Result.ok(data));


    }
}


