package com.mysql.headline.dao;

import com.mysql.headline.pojo.NewsHeadline;
import com.mysql.headline.pojo.vo.HeadlineDetailVo;
import com.mysql.headline.pojo.vo.HeadlinePageVo;
import com.mysql.headline.pojo.vo.HeadlineQueryVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:07
 */
public interface NewsHeadLineDao {
    List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo);

    Integer findPageCount(HeadlineQueryVo headlineQueryVo);

    HeadlineDetailVo findHeadlineDetail(String hid);

    void incrPageView(String hid);

    Integer addNewHeadline(NewsHeadline newsHeadline);

    NewsHeadline findHeadlineByHid(String hid);

    Integer updateHeadline(NewsHeadline newsHeadline);

    Integer deleteHeadline(String hid);
}
