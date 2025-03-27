package com.myself.schedule.service;

import com.myself.schedule.pojo.SysUser;
import com.myself.schedule.service.impl.SysUserServiceImpl;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/26 15:23
 */
public interface SysUserService {
    /**
     * 注册用户的方法
     * @param sysUser  要注册的用户对象
     * @return   返回布尔类型，成功为true
     */
    int register(SysUser sysUser);
}
