package com.myself.schedule.Dao.impl;

import com.myself.schedule.Dao.BaseDao;
import com.myself.schedule.Dao.SysScheduleDao;
import com.myself.schedule.pojo.SysSchedule;

import java.util.List;
import java.util.StringTokenizer;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/22 20:58
 */
public class SysScheduleDaoImpl  extends BaseDao implements SysScheduleDao {


    @Override
    public int addSchedule(SysSchedule schedule) {

        String sql ="INSERT INTO sys_schedule values (null,?,?,?)";

        return baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql ="SELECT sid,uid,title,completed from sys_schedule";
        return baseQuery(SysSchedule.class,sql,null);
    }

    @Override
    public List<SysSchedule> finItemListByUid(int uid) {
        String sql = "select sid,uid,title,completed from sys_schedule where uid = ?";
        return baseQuery(SysSchedule.class, sql, uid);
    }

    @Override
    public void addNewSchedule(Integer uid) {
        String sql = "insert INTO sys_schedule values(DEFAULT,?,'请输入日程信息',0)";
        baseUpdate(sql,uid);
    }

    @Override
    public void saveChange(SysSchedule sysSchedule) {
        String sql = "UPDATE sys_schedule SET title=?,completed=? where sid= ? ";
        baseUpdate(sql,sysSchedule.getTitle(), sysSchedule.getCompleted(),sysSchedule.getSid());
    }

    @Override
    public void dropSchedule(SysSchedule sysSchedule) {
        String sql = "DELETE  FROM sys_schedule where sid=?";
        baseUpdate(sql,sysSchedule.getSid());
    }
}
