package com.mysql.headline.test;

import com.mysql.headline.util.JwtHelper;
import org.junit.Test;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 16:33
 */
public class TestJwtHelper {
    @Test
    public void testAllMethod() throws InterruptedException {
        String token = JwtHelper.createToken(123456L);

        System.out.println(token);

        //反向解析
        Long userId = JwtHelper.getUserId(token);
        System.out.println(userId);
        //看token有没有过期
        boolean expiration = JwtHelper.isExpiration(token);
        System.out.println(expiration);

        Thread.sleep(6000);
        System.out.println(JwtHelper.isExpiration(token));


    }
}
