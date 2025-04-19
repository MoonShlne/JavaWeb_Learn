package com.myself.schedule.service.impl;
import com.myself.schedule.Dao.impl.SysUserDaoImpl;
import com.myself.schedule.pojo.SysUser;
import com.myself.schedule.service.SysUserService;
import com.myself.schedule.util.MD5Util;


/**
 * @author polar
 * @version 1.0
 * @since 2025/3/26 16:05
 */
public class SysUserServiceImpl  implements SysUserService {
   private final SysUserDaoImpl UserDao = new SysUserDaoImpl();
    @Override
    public int register(SysUser sysUser) {
        //将密码转换为密文
        String password = sysUser.getPassword();
        String encrypt = MD5Util.encrypt(password);
        sysUser.setPassword(encrypt);
        //调用DAO  将信息存入数据库

      return UserDao.addSysUser(sysUser);
    }

    @Override
    public boolean findUserName(SysUser sysUser) {

        return UserDao.findName(sysUser);

    }

    @Override
    public boolean findPassword(SysUser sysUser) {
        //将密码转换为密文
        sysUser.setPassword(MD5Util.encrypt(sysUser.getPassword()));


        return UserDao.findPassword(sysUser);
    }

    @Override
    public SysUser findUser(SysUser sysUser) {
        return  UserDao.findUser(sysUser);
    }
}
