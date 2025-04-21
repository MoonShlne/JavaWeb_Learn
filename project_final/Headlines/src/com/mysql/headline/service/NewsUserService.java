package com.mysql.headline.service;

import com.mysql.headline.pojo.NewsUser;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:08
 */
public interface NewsUserService {
    /**
     从传进来的一个user查询在数据库中的对象
     * @return 一个user对象
     */
    NewsUser findUser(NewsUser newsUser);

    NewsUser findByUid(Integer uid);

    NewsUser findByUserName(String username);

    Integer addNewUser(NewsUser user);
}
