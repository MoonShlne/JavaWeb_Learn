package com.mysql.headline.dao;

import com.mysql.headline.pojo.NewsUser;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:05
 */
public interface NewsUserDao {
    NewsUser findUser(NewsUser newsUser);

    NewsUser findByUid(Integer uid);

    NewsUser findByUserName(String username);

    Integer addNewUser(NewsUser user);
}
