package com.mysql.headline.service.impl;

import com.mysql.headline.dao.NewsHeadLineDao;
import com.mysql.headline.dao.impl.NewsHeadLineDaoImpl;
import com.mysql.headline.pojo.NewsHeadline;
import com.mysql.headline.pojo.vo.HeadlineDetailVo;
import com.mysql.headline.pojo.vo.HeadlinePageVo;
import com.mysql.headline.pojo.vo.HeadlineQueryVo;
import com.mysql.headline.service.NewsHeadlineService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:09
 */
public class NewsHeadlineServiceImpl implements NewsHeadlineService {

    private final NewsHeadLineDaoImpl headLineDao = new NewsHeadLineDaoImpl();

    /**
     * "pageData":[                           // 本页的数据
     * {
     * "hid":"1",                     // 新闻id
     * "title":"尚硅谷宣布 ... ...",   // 新闻标题
     * "type":"1",                    // 新闻所属类别编号
     * "pageViews":"40",              // 新闻浏览量
     * "pastHours":"3" ,              // 发布时间已过小时数
     * "publisher":"1"                // 发布用户ID
     * },
     * ],
     * "pageNum":1,    //页码数
     * "pageSize":10,  // 页大小
     * "totalPage":20, // 总页数
     * "totalSize":200 // 总记录数
     * <p>
     * 以上是返回值，一个map
     * key value 分别为
     * pageData   List
     * pageNum   int
     * pageSize   int
     * totalPage  int
     * totalSize  int
     */
    @Override
    public Map<String,Object> findPage(HeadlineQueryVo headlineQueryVo) {
        //创造需要返回的map
        HashMap<String, Object> mapInfo = new HashMap<>();
        //准备map的内容

        List<HeadlinePageVo> pageData = headLineDao.findPageList(headlineQueryVo);
        Integer totalSize = headLineDao.findPageCount(headlineQueryVo);
        //所有的新闻信息
        mapInfo.put("pageData", pageData);
        //页码数
        mapInfo.put("pageNum", headlineQueryVo.getPageNum());
        //单页数量
        mapInfo.put("pageSize", headlineQueryVo.getPageSize());
        //总页数
        mapInfo.put("totalPage", totalSize % headlineQueryVo.getPageSize() == 0 ?
                totalSize / headlineQueryVo.getPageSize() : totalSize / headlineQueryVo.getPageSize() + 1);
        //总记录数
        mapInfo.put("totalSize", totalSize);


        return mapInfo;
    }

    @Override
    public HeadlineDetailVo findHeadlineDetail(String hid) {
        headLineDao.incrPageView(hid);
        return headLineDao.findHeadlineDetail(hid);
    }

    /**
     *
     * @param newsHeadline 客户端传来的对象 自带 publisher, title,article,type
     * @return 返回影响行数
     */
    @Override
    public Integer addNewHeadline(NewsHeadline newsHeadline) {
        return headLineDao.addNewHeadline(newsHeadline);
    }

    /**
     根据hid 返回newsHeadline
     */
    @Override
    public NewsHeadline findHeadlineByHid(String hid) {
        return headLineDao.findHeadlineByHid(hid);
    }

    @Override
    public Integer updateHeadline(NewsHeadline newsHeadline) {
        return headLineDao.updateHeadline(newsHeadline);
    }

    @Override
    public Integer deleteHeadline(String hid) {
        return headLineDao.deleteHeadline(hid);
    }
}
