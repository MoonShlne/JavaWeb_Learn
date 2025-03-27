package com.myself.schedule.test;

import com.myself.schedule.Dao.impl.SysScheduleDaoImpl;
import com.myself.schedule.pojo.SysSchedule;
import org.junit.Test;

import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/26 14:54
 */
public class TestScheduleDao {

    @Test
    public void testAddSchedule(){
        SysScheduleDaoImpl sysScheduleDao = new SysScheduleDaoImpl();
        SysSchedule newSchedule = new SysSchedule(null, 2, "今天吃了吗", 0);
        sysScheduleDao.addSchedule(newSchedule);


    }

    @Test
    public void testSelectAll(){
        SysScheduleDaoImpl sysScheduleDao = new SysScheduleDaoImpl();

        List<SysSchedule> all = sysScheduleDao.findAll();
        all.forEach(System.out::println);

    }
}
