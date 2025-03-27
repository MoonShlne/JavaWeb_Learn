package com.myself.schedule.Dao.impl;

import com.myself.schedule.Dao.BaseDao;
import com.myself.schedule.Dao.SysScheduleDao;
import com.myself.schedule.pojo.SysSchedule;

import java.util.List;

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
}
