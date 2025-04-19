package com.myself.schedule.test;

import com.myself.schedule.Dao.BaseDao;
import com.myself.schedule.Dao.impl.SysUserDaoImpl;
import com.myself.schedule.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/23 14:05
 */
public class TestBaseDao {
    private static BaseDao baseDao;

    @BeforeClass
    public static void  initBaseDao(){
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseQueryObject() {
        String sql = "select count(1)  from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }

    @Test
    public void testBaseQuery(){
        String sql ="select uid,username,user_pwd password from sys_user";
        List<Object> objects = baseDao.baseQuery(SysUser.class, sql);
        objects.forEach(System.out::println);
    }

    @Test
    public void testVaseUpdate(){
        String sql ="insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseDao.baseUpdate(sql, 1, "不学JDBC", 0);
        System.out.println(rows);

    }
    @Test
    public void testUserImpl(){
        SysUserDaoImpl sysUserDao = new SysUserDaoImpl();
        List<SysUser> all = sysUserDao.findAll();
        all.forEach(System.out::println);

    }

}
