package com.yixi.micro.service.impl;

import com.yixi.micro.dao.NewsTypeDao;
import com.yixi.micro.dao.impl.NewsTypeDaoImpl;
import com.yixi.micro.pojo.NewsType;
import com.yixi.micro.service.NewsTypeService;

import javax.servlet.annotation.WebServlet;
import java.util.List;

public class NewsTypeServiceImpl implements NewsTypeService {

    private NewsTypeDao typeDao= new NewsTypeDaoImpl();

    /**
     *
     * @return
     */
    @Override
    public List<NewsType> findAll() {

        return typeDao.findAll();
    }
}
