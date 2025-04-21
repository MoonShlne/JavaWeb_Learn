package com.mysql.headline.service;

import com.mysql.headline.pojo.NewsType;

import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:08
 */
public interface NewsTypeService {
    List<NewsType> finAllTypes();
}
