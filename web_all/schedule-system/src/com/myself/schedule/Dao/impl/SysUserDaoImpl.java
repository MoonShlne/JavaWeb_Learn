package com.myself.schedule.Dao.impl;

import com.myself.schedule.Dao.BaseDao;
import com.myself.schedule.Dao.SysScheduleDao;
import com.myself.schedule.Dao.SysUserDao;
import com.myself.schedule.pojo.SysSchedule;
import com.myself.schedule.pojo.SysUser;
import com.myself.schedule.util.JDBCUtil;

import java.sql.Connection;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/22 20:56
 */
public class SysUserDaoImpl implements SysUserDao {
    BaseDao baseDao = new BaseDao();


    @Override
    public int addSysUser(SysUser sysUser) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "INSERT INTO sys_user  values(DEFAULT ,?,?)";
        return baseDao.baseUpdate(sql, sysUser.getUsername(), sysUser.getPassword());
    }
}
