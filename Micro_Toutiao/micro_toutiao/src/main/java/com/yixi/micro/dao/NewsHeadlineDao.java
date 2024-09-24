package com.yixi.micro.dao;

import com.yixi.micro.pojo.NewsHeadline;
import com.yixi.micro.pojo.vo.HeadlineDetailVo;
import com.yixi.micro.pojo.vo.HeadlinePageVo;
import com.yixi.micro.pojo.vo.HeadlineQueryVo;

import java.util.List;

public interface NewsHeadlineDao {

    /** 根据前端响应查询 headline page的信息
     *
     * @param headlineQueryVo
     * @return
     */
    List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo);

    /**
     * 查询page的总记录
     * @param headlineQueryVo
     * @return
     */
    int findPageCount(HeadlineQueryVo headlineQueryVo);

    /**
     * 查询具体新闻内容
     * @param hid
     * @return
     */
    HeadlineDetailVo findHeadlineDetail(Integer hid);

    int increasePageViews(Integer hid);

    /**
     * 添加新闻
     * @param newsHeadline
     * @return
     */
    Integer addNewsHeadline(NewsHeadline newsHeadline);

    NewsHeadline findHeadlineByHid(Integer hid);

    int updateNewsHeadline(NewsHeadline newsHeadline);

    /**
     * 根据新闻id删除
     * @param hid
     * @return
     */
    int removeByHid(int hid);
}
