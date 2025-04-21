package com.mysql.headline.dao.impl;

import com.mysql.headline.dao.BaseDao;
import com.mysql.headline.dao.NewsTypeDao;
import com.mysql.headline.dao.NewsUserDao;
import com.mysql.headline.pojo.NewsType;

import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:06
 */
public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {

    @Override
    public List<NewsType> findAllType() {
        String sql ="SELECT * FROM news_type";
        return baseQuery(NewsType.class, sql);
    }
}
