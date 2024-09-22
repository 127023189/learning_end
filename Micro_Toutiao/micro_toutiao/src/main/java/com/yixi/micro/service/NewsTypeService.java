package com.yixi.micro.service;

import com.yixi.micro.pojo.NewsType;

import java.util.List;

public interface NewsTypeService {

    /**
     * 查询所有头条类型的方法
     * @return List<NewType> 形式返回
     */
    List<NewsType> findAll();
}
