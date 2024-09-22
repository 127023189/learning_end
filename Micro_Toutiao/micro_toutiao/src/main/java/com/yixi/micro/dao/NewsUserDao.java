package com.yixi.micro.dao;

import com.yixi.micro.pojo.NewsUser;

public interface NewsUserDao {
    /**
     * 根据username 查找用户
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
