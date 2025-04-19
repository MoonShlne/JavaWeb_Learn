package com.myself.schedule.test;

import com.myself.schedule.Dao.BaseDao;
import com.myself.schedule.Dao.impl.SysUserDaoImpl;
import com.myself.schedule.pojo.SysUser;
import com.myself.schedule.util.MD5Util;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/16 15:08
 */
public class TestUserDao {

    @Test
    public void test(){
        SysUserDaoImpl sysUserDao = new SysUserDaoImpl();
        SysUser sysUser = new SysUser(null,"1111111","111111");
        SysUser user = sysUserDao.findUser(sysUser);
        System.out.println(user);
    }

    @Test
    public void test2(){
        SysUserDaoImpl sysUserDao = new SysUserDaoImpl();

        List<SysUser> all = sysUserDao.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void test4(){
        System.out.println(Charset.defaultCharset().displayName());

    }
}
