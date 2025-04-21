package com.mysql.headline.service.impl;

import com.mysql.headline.dao.impl.NewsTypeDaoImpl;
import com.mysql.headline.pojo.NewsType;
import com.mysql.headline.service.NewsTypeService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:09
 */
public class NewsTypeServiceImpl implements NewsTypeService {
    private final NewsTypeDaoImpl typeDao = new NewsTypeDaoImpl();
    @Override
    public List<NewsType> finAllTypes() {
        return typeDao.findAllType();
    }
}
