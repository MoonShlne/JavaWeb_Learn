package com.mysql.headline.dao;

import com.mysql.headline.pojo.NewsType;

import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:05
 */
public interface NewsTypeDao {
    List<NewsType> findAllType();
}
