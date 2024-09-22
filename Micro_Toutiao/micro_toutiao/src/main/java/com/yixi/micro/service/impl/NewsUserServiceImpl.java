package com.yixi.micro.service.impl;

import com.yixi.micro.dao.NewsUserDao;
import com.yixi.micro.dao.impl.NewsUserDaoImpl;
import com.yixi.micro.pojo.NewsUser;
import com.yixi.micro.service.NewsUserService;

public class NewsUserServiceImpl implements NewsUserService {
    private NewsUserDao newsUserDao = new NewsUserDaoImpl();
    @Override
    public NewsUser findByUsername(String username) {
        NewsUser newsUser = newsUserDao.findByUsername(username);
        return newsUser;
    }

    @Override
    public NewsUser findByUid(Integer uid) {
        NewsUser newsUser = newsUserDao.findByUid(uid);
        return newsUser;
    }
}
