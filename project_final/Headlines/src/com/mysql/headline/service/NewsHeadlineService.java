package com.mysql.headline.service;

import com.mysql.headline.pojo.NewsHeadline;
import com.mysql.headline.pojo.vo.HeadlineDetailVo;
import com.mysql.headline.pojo.vo.HeadlineQueryVo;

import java.util.Map;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:08
 */
public interface NewsHeadlineService {
    Map<String,Object> findPage(HeadlineQueryVo headlineQueryVo);

    HeadlineDetailVo findHeadlineDetail(String hid);

    Integer addNewHeadline(NewsHeadline newsHeadline);

    NewsHeadline findHeadlineByHid(String hid);

    Integer updateHeadline(NewsHeadline newsHeadline);

    Integer deleteHeadline(String hid);
}
