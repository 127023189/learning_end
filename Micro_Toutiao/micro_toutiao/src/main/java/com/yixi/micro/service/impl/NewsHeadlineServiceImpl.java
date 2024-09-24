package com.yixi.micro.service.impl;


import com.yixi.micro.dao.NewsHeadlineDao;
import com.yixi.micro.dao.impl.NewsHeadlineDaoImpl;
import com.yixi.micro.pojo.NewsHeadline;
import com.yixi.micro.pojo.vo.HeadlineDetailVo;
import com.yixi.micro.pojo.vo.HeadlinePageVo;
import com.yixi.micro.pojo.vo.HeadlineQueryVo;
import com.yixi.micro.service.NewsHeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsHeadlineServiceImpl implements NewsHeadlineService {

    private NewsHeadlineDao headlineDao= new NewsHeadlineDaoImpl();
    @Override
    public Map<String, Object> findPage(HeadlineQueryVo headLineQueryVo) {
        Map<String,Object> pageInfo =new HashMap<>();

        //分页查询本页数据
        List<HeadlinePageVo> pageData = headlineDao.findPageList(headLineQueryVo);

        //查询记录的总条数
        int totalSize = headlineDao.findPageCount(headLineQueryVo);

        // 查询页的大小
        int pageSize = headLineQueryVo.getPageSize();
        int pageNum = headLineQueryVo.getPageNum();

        int totalPage=totalSize%pageSize == 0 ?  totalSize/pageSize  : totalSize/pageSize+1;

        pageInfo.put("pageData",pageData);
        pageInfo.put("pageNum",pageNum);
        pageInfo.put("pageSize",pageSize);
        pageInfo.put("totalPage",totalPage);
        pageInfo.put("totalSize",totalSize);

        return pageInfo;
    }

    @Override
    public HeadlineDetailVo findHeadlineDetail(Integer hid) {
        // 浏览量+1
        headlineDao.increasePageViews(hid);

        return headlineDao.findHeadlineDetail(hid);
    }
}
