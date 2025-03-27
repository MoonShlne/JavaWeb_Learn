package com.myself.schedule.test;

import com.myself.schedule.util.MD5Util;
import org.junit.Test;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/26 18:49
 */
public class TestMD5Util {

    @Test
    public void test(){
        String encrypt = MD5Util.encrypt("123455");
        System.out.println(encrypt);
    }
}
