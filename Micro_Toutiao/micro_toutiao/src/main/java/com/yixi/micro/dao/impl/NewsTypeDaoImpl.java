package com.yixi.micro.dao.impl;

import com.yixi.micro.dao.BaseDao;
import com.yixi.micro.dao.NewsTypeDao;
import com.yixi.micro.dao.NewsUserDao;
import com.yixi.micro.pojo.NewsType;

import java.util.List;

public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {

    @Override
    public List<NewsType> findAll() {
        String sql= "select tid,tname from news_type";
        return baseQuery(NewsType.class,sql);
    }
}
