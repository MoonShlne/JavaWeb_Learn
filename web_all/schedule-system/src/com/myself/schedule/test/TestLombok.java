package com.myself.schedule.test;

import com.myself.schedule.pojo.SysUser;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/22 16:50
 */
public class TestLombok {
    public  void  testAnnotation(){
        SysUser s= new SysUser();
        new SysUser(111,"aaa","fsd ");
    }
}
