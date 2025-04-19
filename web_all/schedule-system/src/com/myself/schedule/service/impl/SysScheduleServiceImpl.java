package com.myself.schedule.service.impl;

import com.myself.schedule.Dao.impl.SysScheduleDaoImpl;
import com.myself.schedule.pojo.SysSchedule;
import com.myself.schedule.service.SysScheduleService;

import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/18 14:51
 */
public class SysScheduleServiceImpl implements SysScheduleService {
     SysScheduleDaoImpl scheduleDao = new SysScheduleDaoImpl();
    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        return scheduleDao.finItemListByUid(uid);
    }

    @Override
    public void addNewSchedule(Integer uid) {
        scheduleDao.addNewSchedule(uid);
    }

    @Override
    public void saveChange(SysSchedule sysSchedule) {
        scheduleDao.saveChange(sysSchedule);

    }

    @Override
    public void dropSchedule(SysSchedule sysSchedule) {
        scheduleDao.dropSchedule(sysSchedule);
    }


}
