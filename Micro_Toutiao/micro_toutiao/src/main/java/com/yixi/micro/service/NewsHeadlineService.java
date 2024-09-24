package com.yixi.micro.service;

import com.yixi.micro.pojo.NewsHeadline;
import com.yixi.micro.pojo.vo.HeadlineDetailVo;
import com.yixi.micro.pojo.vo.HeadlineQueryVo;

import java.util.Map;

public interface NewsHeadlineService {

    /**
     * 根据前端参数，查找当前显示的页面信息
     * @param headLineQueryVo
     * @return
     */
    Map<String,Object> findPage(HeadlineQueryVo headLineQueryVo);

    HeadlineDetailVo findHeadlineDetail(Integer hid);
}
