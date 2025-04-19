package com.myself.schedule.controller;

import com.myself.schedule.common.Result;
import com.myself.schedule.pojo.SysSchedule;
import com.myself.schedule.pojo.SysUser;
import com.myself.schedule.service.SysScheduleService;
import com.myself.schedule.service.impl.SysScheduleServiceImpl;
import com.myself.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/26 16:14
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
    private final SysScheduleServiceImpl scheduleService = new SysScheduleServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("aaa");

    }

    /**
     * @throws IOException 通过前端返回的uid查找到该id的日程信息，返回给前端
     */
    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受UID参数
        Integer uid = Integer.parseInt(req.getParameter("uid"));
//        System.out.println(uid);
        //获得所有日程
        List<SysSchedule> itemList = scheduleService.findItemListByUid(uid);
        HashMap<Object, Object> data = new HashMap<>();
        data.put("itemList", itemList);

        Result<HashMap<Object, Object>> result = Result.ok(data);
        //放入一个json返回给前端
        WebUtil.writeJson(resp, result);

    }

    /**
     * 向数据库新增一条uid为 ？的数据
     * 数据为默认 待后续保存
     */
    protected void addNewSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //获得uid
        Integer uid = Integer.parseInt(req.getParameter("uid"));
        //插入数据
        scheduleService.addNewSchedule(uid);
    }

    /**
     * 前端返回一个除了sid之外全新的sysSchedule对象，根据sid把数据更新
     */
    protected void saveChange(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受数据
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        //调用service层的方法
        scheduleService.saveChange(sysSchedule);
    }

    /**
     前端发送一个sysSchedule对象，根据对象的sid从数据库删除该日程
     */
    protected void dropSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);

        scheduleService.dropSchedule(sysSchedule);


    }
}
