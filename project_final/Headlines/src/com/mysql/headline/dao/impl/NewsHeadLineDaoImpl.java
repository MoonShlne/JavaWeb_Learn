package com.mysql.headline.dao.impl;

import com.mysql.headline.dao.BaseDao;
import com.mysql.headline.dao.NewsHeadLineDao;
import com.mysql.headline.pojo.NewsHeadline;
import com.mysql.headline.pojo.vo.HeadlineDetailVo;
import com.mysql.headline.pojo.vo.HeadlinePageVo;
import com.mysql.headline.pojo.vo.HeadlineQueryVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author polar
 * @version 1.0
 * @since 2025/4/19 14:06
 */
public class NewsHeadLineDaoImpl extends BaseDao implements NewsHeadLineDao {
    /**
     * 返回列表的属性值
     * private Integer hid;
     * private String title;
     * private Integer type;
     * private Integer pageViews;
     * private Long pastHours;
     * private Integer publisher;
     *
     * @param headlineQueryVo 索要查询的内容
     * @return 一个list 包含所有的新闻信息
     */
    @Override
    public List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo) {
        ArrayList<Object> params = new ArrayList<>();
        String sql = """
                SELECT
                hid,
                title,
                type,
                page_views as pageViews,
                TIMESTAMPDIFF(HOUR,create_time,NOW()) pastHours ,
                publisher
                from news_headline
                where is_deleted =0
                """;

        //请求的type为0则查询所有字段 ，否则为特定字段
        if (headlineQueryVo.getType() != 0) {
            sql = sql.concat(" and type=? ");
            params.add(headlineQueryVo.getType());
        }
        //请求是否搜？ keywords是否为空?  全部查询:模糊查询
        if (headlineQueryVo.getKeyWords() != null && !headlineQueryVo.getKeyWords().isEmpty()) {
            sql = sql.concat(" and title like ?");
            params.add("%" + headlineQueryVo.getKeyWords() + "%");
        }

        //返回的数据要具有时效性，优先时间排序，时间相同则用查看数量排序
        sql = sql.concat(" order by create_time asc , page_views desc");

        //限制条目数量,例如传来的请求是第三页内容，每页5条数据，则排序后从第15条开始
        sql = sql.concat(" limit ?, ?");
        params.add((headlineQueryVo.getPageNum() - 1) * headlineQueryVo.getPageSize());
        params.add(headlineQueryVo.getPageSize());

        return baseQuery(HeadlinePageVo.class, sql, params.toArray());

    }

    @Override
    public Integer findPageCount(HeadlineQueryVo headlineQueryVo) {
        ArrayList<Object> params = new ArrayList<>();
        String sql = """
                SELECT
                count(1)
                from news_headline
                where is_deleted =0
                """;

        //请求的type为0则查询所有字段 ，否则为特定字段
        if (headlineQueryVo.getType() != 0) {
            sql = sql.concat(" and type=? ");
            params.add(headlineQueryVo.getType());
        }
        //请求是否搜？ keywords是否为空?  全部查询:模糊查询
        if (headlineQueryVo.getKeyWords() != null && !headlineQueryVo.getKeyWords().isEmpty()) {
            sql = sql.concat(" and title like ?");
            params.add("%" + headlineQueryVo.getKeyWords() + "%");
        }

        Long count = baseQueryObject(Long.class, sql, params.toArray());
        return count.intValue();
    }

    @Override
    public HeadlineDetailVo findHeadlineDetail(String hid) {


        String sql2 = """
                select
                    hid,
                    title,
                    article,
                    type,
                    tname  typeName,
                    page_views pageViews,
                    TIMESTAMPDIFF(HOUR,create_time,NOW()) pastHours,
                    publisher,
                    nick_name author
                from
                    news_headline join news_type join news_user on
                    news_headline.publisher =news_user.uid and  news_headline.type =news_type.tid
                where hid=?;
                """;
        return (HeadlineDetailVo) baseQuery(HeadlineDetailVo.class, sql2, hid).get(0);
    }

    @Override
    public void incrPageView(String hid) {
        String sql1 = """
                update news_headline SET  page_views=page_views+1 where hid =?
                """;
        baseUpdate(sql1, hid);
    }

    //形参对象自带 publisher, title,article,type
    @Override
    public Integer addNewHeadline(NewsHeadline newsHeadline) {
        String sql = """
                INSERT INTO news_headline
                values(
                DEFAULT,
                ?,
                ?,
                ?,
                ?,
                0,
                now(),
                now(),
                0
                )
                """;

        return baseUpdate(sql, newsHeadline.getTitle(), newsHeadline.getArticle(),
                newsHeadline.getType(), newsHeadline.getPublisher());
    }

    @Override
    public NewsHeadline findHeadlineByHid(String hid) {
        String sql = """
                select hid,title,article,type,
                 publisher,
                 page_views pageViews,
                 create_time createTime,
                 update_time updateTime,
                 is_deleted isDeleted
                 from news_headline
                  where hid =?
                """;
        return (NewsHeadline) baseQuery(NewsHeadline.class, sql, hid).get(0);
    }

    @Override
    public Integer updateHeadline(NewsHeadline newsHeadline) {
        String sql = """
                UPDATE news_headline SET
                title =?,
                article=?,
                type =?,
                update_time =now()
                where hid =?
                """;
        return baseUpdate(sql,
                newsHeadline.getTitle(),
                newsHeadline.getArticle(),
                newsHeadline.getType(),
                newsHeadline.getHid());

    }

    @Override
    public Integer deleteHeadline(String hid) {
        String sql ="update news_headline set is_deleted =1 where hid =?";
        return baseUpdate(sql,hid);
    }
}
