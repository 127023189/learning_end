package com.yixi.micro.service;

import com.yixi.micro.pojo.NewsUser;

public interface NewsUserService {
    /**
     * 根据用户名查找 是否存在用户
     * @param username
     * @return
     */
    public abstract NewsUser findByUsername(String username);

    /**
     * 根据uid查找信息
     * @param uid
     * @return
     */
    NewsUser findByUid(Integer uid);
}
