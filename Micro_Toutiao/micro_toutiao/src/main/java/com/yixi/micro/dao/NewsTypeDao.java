package com.yixi.micro.dao;

import com.yixi.micro.pojo.NewsType;

import java.util.List;

public interface NewsTypeDao {

    /**
     * 查询头条的类型
     * @return
     */
    List<NewsType> findAll();
}
