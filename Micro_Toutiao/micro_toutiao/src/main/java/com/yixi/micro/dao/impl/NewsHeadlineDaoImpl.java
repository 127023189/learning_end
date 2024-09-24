package com.yixi.micro.dao.impl;

import com.yixi.micro.dao.BaseDao;
import com.yixi.micro.dao.NewsHeadlineDao;
import com.yixi.micro.pojo.NewsHeadline;
import com.yixi.micro.pojo.vo.HeadlineDetailVo;
import com.yixi.micro.pojo.vo.HeadlinePageVo;
import com.yixi.micro.pojo.vo.HeadlineQueryVo;

import java.util.LinkedList;
import java.util.List;



public class NewsHeadlineDaoImpl extends BaseDao implements NewsHeadlineDao{


    @Override
    public int updateNewsHeadline(NewsHeadline newsHeadline) {
        String sql = "update  news_headline set title=?, article= ? , type =? , update_time = NOW() where hid = ? ";
        return baseUpdate(sql,
                newsHeadline.getTitle(),
                newsHeadline.getArticle(),
                newsHeadline.getType(),
                newsHeadline.getHid());
    }

    @Override
    public int findPageCount(HeadlineQueryVo headLineQueryVo) {

        System.out.println("findPageCount ...");
        //  拼接动态 SQL,拼接参数
        List<Object> args =new LinkedList<>();
        String  sql="select count(1) from news_headline where is_deleted=0 ";
        StringBuilder sqlBuffer =new StringBuilder(sql) ;
        String keyWords = headLineQueryVo.getKeyWords();
        //判断并动态拼接条件
        if (null != keyWords && keyWords.length()>0){
            sqlBuffer.append("and title like ? ");
            args.add("%"+keyWords+"%");
        }
        Integer type = headLineQueryVo.getType();
        if(null != type  && type != 0){
            sqlBuffer.append("and type  =  ? ");
            args.add(type);
        }

        // 参数转数组
        Object[] argsArr = args.toArray();

        Long totalSize = baseQueryObject(Long.class, sqlBuffer.toString(),argsArr);
        // 返回数据
        System.out.println(totalSize + " totalSize");
        return totalSize.intValue();
    }

    @Override
    public List<HeadlinePageVo> findPageList(HeadlineQueryVo headLineQueryVo) {
        //  拼接动态 SQL,拼接参数
        System.out.println("findPageList ... ");
        List<Object> args =new LinkedList<>();
        String  sql="select hid,title,type,page_views pageViews,TIMESTAMPDIFF(HOUR,create_time,NOW()) pastHours,publisher from news_headline where is_deleted=0 ";
        StringBuilder sqlBuffer =new StringBuilder(sql) ;
        String keyWords = headLineQueryVo.getKeyWords();
        if (null != keyWords && keyWords.length()>0){
            sqlBuffer.append("and title like ? ");
            args.add("%"+keyWords+"%");
        }
        Integer type = headLineQueryVo.getType();
        if(null != type  && type != 0){
            sqlBuffer.append("and type  =  ? ");
            args.add(type);
        }

        sqlBuffer.append("order by pastHours , page_views desc ");
        sqlBuffer.append("limit ? , ?");
        args.add((headLineQueryVo.getPageNum()-1)*headLineQueryVo.getPageSize());
        args.add(headLineQueryVo.getPageSize());

        // 参数转数组
        Object[] argsArr = args.toArray();

        List<HeadlinePageVo> pageData = baseQuery(HeadlinePageVo.class, sqlBuffer.toString(), argsArr);
        System.out.println("PageData"+pageData);
        return pageData;
    }

    @Override
    public HeadlineDetailVo findHeadlineDetail(Integer hid) {
        String sql ="select hid,title,article,type, tname typeName ,page_views pageViews,TIMESTAMPDIFF(HOUR,create_time,NOW()) pastHours,publisher,nick_name author from news_headline h left join  news_type t on h.type = t.tid left join news_user u  on h.publisher = u.uid where hid = ?";
        List<HeadlineDetailVo> headlineDetailVos = baseQuery(HeadlineDetailVo.class, sql, hid);
        if(headlineDetailVos != null && headlineDetailVos.size() > 0)
            return headlineDetailVos.get(0);
        return null;
    }

    @Override
    public int increasePageViews(Integer hid) {
        String sql ="update news_headline set page_views = page_views +1 where hid =?";
        return baseUpdate(sql,hid);
    }

    @Override
    public Integer addNewsHeadline(NewsHeadline newsHeadline) {
        String sql = "insert into news_headline values(null,?,?,?,?,0,NOW(),NOW(),0)";
        return baseUpdate(sql,newsHeadline.getTitle(),
                newsHeadline.getArticle(),
                newsHeadline.getType(),
                newsHeadline.getPublisher()
                );
    }

    @Override
    public NewsHeadline findHeadlineByHid(Integer hid) {
        String sql = "select hid,title,article,type,publisher,page_views pageViews from news_headline where hid =?";
        List<NewsHeadline> newsHeadlineList = baseQuery(NewsHeadline.class, sql, hid);
        if(null != newsHeadlineList && newsHeadlineList.size()>0)
            return newsHeadlineList.get(0);
        return null;
    }

    @Override
    public int removeByHid(int hid) {
        String sql = "update news_headline set is_deleted =1 ,  update_time =NOW() where hid = ? ";
        return baseUpdate(sql,hid);
    }
}