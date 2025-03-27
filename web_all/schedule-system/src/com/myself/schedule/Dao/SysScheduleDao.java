package com.myself.schedule.Dao;

import com.myself.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/22 20:54
 */
public interface SysScheduleDao {
    /**
     *  用于向数据库增加一条日程记录
     * @param schedule   日程数据以sysSchedule对象作为形参
     * @return    返回数据库影响行数  行数为0则为增加失败，return 0
     */
        int addSchedule(SysSchedule schedule);

    /**
     * 查询所有日程信息
     * @return 返回一个list对象集合
     */
    List<SysSchedule> findAll();
}
