package com.myself.schedule.Dao.impl;

import com.myself.schedule.Dao.BaseDao;
import com.myself.schedule.Dao.SysScheduleDao;
import com.myself.schedule.Dao.SysUserDao;
import com.myself.schedule.pojo.SysSchedule;
import com.myself.schedule.pojo.SysUser;
import com.myself.schedule.util.JDBCUtil;

import java.sql.Connection;
import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/22 20:56
 */
public class SysUserDaoImpl implements SysUserDao {
    BaseDao baseDao = new BaseDao();


    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "INSERT INTO sys_user  values(DEFAULT ,?,?)";
        return baseDao.baseUpdate(sql, sysUser.getUsername(), sysUser.getPassword());
    }

    @Override
    public boolean findName(SysUser sysUser) {
        String sql = "SELECT uid , username ,user_pwd as password FROM sys_user WHERE username = ?";
        List<Object> objects = baseDao.baseQuery(SysUser.class, sql, sysUser.getUsername());
        if (objects.isEmpty()){
            return false;
        }
        else if (objects.size() == 1 ){
            return true;
        }
        else {
            throw new RuntimeException("数据库用户名重复");
        }

    }

    @Override
    public boolean findPassword(SysUser sysUser) {
        String sql = "SELECT uid , username ,user_pwd as password  FROM sys_user WHERE username =? AND user_pwd = ?  ";
        List<Object> objects = baseDao.baseQuery(SysUser.class, sql,sysUser.getUsername(), sysUser.getPassword());
        if (objects.isEmpty()){
            return false;
        }
        else if (objects.size() ==1 ){
            return true;
        }
        else {
            throw new RuntimeException("数据库用户名重复");
        }

    }

    @Override
    public List<SysUser> findAll() {
            String sql ="SELECT * from sys_user";
            return baseDao.baseQuery(SysUser.class,sql,null);

    }

}
