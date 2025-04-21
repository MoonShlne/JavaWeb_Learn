package com.mysql.headline.dao.impl;

import com.mysql.headline.dao.BaseDao;
import com.mysql.headline.dao.NewsUserDao;
import com.mysql.headline.pojo.NewsUser;

import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:06
 */
public class NewsUserDaoImpl extends BaseDao implements NewsUserDao {
    @Override
    public NewsUser findUser(NewsUser newsUser) {
        String sql = """
                select uid,username,user_pwd userPwd , nick_name nickName
                from news_user
                where username =?
                """;
        List<NewsUser> objects = baseQuery(NewsUser.class, sql, newsUser.getUsername());
       return objects != null && !objects.isEmpty() ? objects.get(0):null;
    }

    @Override
    public NewsUser findByUid(Integer uid) {
        String sql = """
                select uid,username,user_pwd userPwd , nick_name nickName
                from news_user
                where uid =?
                """;
        List<NewsUser> objects = baseQuery(NewsUser.class, sql, uid);
        return objects != null && !objects.isEmpty() ? objects.get(0):null;
    }

    @Override
    public NewsUser findByUserName(String username) {
        String sql = """
                select uid,username,user_pwd userPwd , nick_name nickName
                from news_user
                where username =?
                """;
        List<NewsUser> objects = baseQuery(NewsUser.class, sql, username);
        return objects != null && !objects.isEmpty() ? objects.get(0):null;
    }

    @Override
    public Integer addNewUser(NewsUser user) {
        String sql = """
                INSERT INTO news_user
                values (DEFAULT,?,?,?)
                """;

        return  baseUpdate(sql,user.getUsername(),user.getUserPwd(),user.getNickName());

    }
}
