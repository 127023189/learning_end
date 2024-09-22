package com.yixi.micro.dao.impl;

import com.yixi.micro.dao.BaseDao;
import com.yixi.micro.dao.NewsUserDao;
import com.yixi.micro.pojo.NewsUser;
import com.yixi.micro.util.JDBCUtil;

import java.util.List;

public class NewsUserDaoImpl extends BaseDao implements NewsUserDao {
    @Override
    public NewsUser findByUsername(String username) {
        String sql = "select " +
                " uid," +
                "username," +
                "user_pwd userPwd," +
                "nick_name nickName " +
                "from news_user where username=?";
//        System.out.println(sql);
        List<NewsUser> users = baseQuery(NewsUser.class, sql,username);
        return users != null && users.size() > 0 ? users.get(0):null;
    }

    @Override
    public NewsUser findByUid(Integer uid) {
        String sql = "select " +
                " uid," +
                "username," +
                "user_pwd userPwd," +
                "nick_name nickName " +
                "from news_user where uid=?";
//        System.out.println(sql);
        List<NewsUser> users = baseQuery(NewsUser.class, sql,uid);
        return users != null && users.size() > 0 ? users.get(0):null;
    }
}
