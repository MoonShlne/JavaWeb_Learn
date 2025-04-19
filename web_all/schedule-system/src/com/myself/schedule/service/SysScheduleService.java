package com.myself.schedule.service;

import com.myself.schedule.pojo.SysSchedule;
import com.myself.schedule.pojo.SysUser;

import java.rmi.server.UID;
import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/18 14:49
 */
public interface SysScheduleService {
    /**
     *
     * @param uid 传入一个uid
     * @return  返回一个该uid的日程列表
     */
    List<SysSchedule> findItemListByUid(int uid);

    void addNewSchedule(Integer uid);


    void saveChange(SysSchedule sysSchedule);

    void dropSchedule(SysSchedule sysSchedule);
}
