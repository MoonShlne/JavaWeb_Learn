package com.mysql.headline.service.impl;

import com.mysql.headline.dao.impl.NewsUserDaoImpl;
import com.mysql.headline.pojo.NewsUser;
import com.mysql.headline.service.NewsUserService;
import com.mysql.headline.util.MD5Util;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:09
 */
public class NewsUserServiceImpl  implements NewsUserService {
    private  final NewsUserDaoImpl userDao =new NewsUserDaoImpl();
    @Override
    public NewsUser findUser(NewsUser newsUser) {
        return userDao.findUser(newsUser);
    }

    @Override
    public NewsUser findByUid(Integer uid) {
       return userDao.findByUid(uid);
    }

    @Override
    public NewsUser findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public Integer addNewUser(NewsUser user) {
        //将用户的密码先加密
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));

        return userDao.addNewUser(user);

    }
}
