package com.myself.schedule.Dao;

import com.myself.schedule.pojo.SysSchedule;
import com.myself.schedule.pojo.SysUser;

import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/22 17:26
 */
public interface SysUserDao {
    int addSysUser(SysUser sysUser);

    boolean findName(SysUser sysUser);

    boolean findPassword(SysUser sysUser);

    List<SysUser> findAll();
}
