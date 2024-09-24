package com.yixi.micro.controller;

import com.yixi.micro.common.Result;
import com.yixi.micro.dao.BaseDao;
import com.yixi.micro.pojo.NewsHeadline;
import com.yixi.micro.service.NewsHeadlineService;
import com.yixi.micro.service.impl.NewsHeadlineServiceImpl;
import com.yixi.micro.util.JwtHelper;
import com.yixi.micro.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/headline/*") // 处理headline所有的请求
public class NewsHeadlineController extends BaseController {
    private NewsHeadlineService newsHeadlineService = new NewsHeadlineServiceImpl();
    /**
     * 发布头条
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        String token = req.getHeader("token");
        Long userId = JwtHelper.getUserId(token);

        newsHeadline.setPublisher(userId.intValue());

        newsHeadlineService.addNewsHeadline(newsHeadline);

        WebUtil.writeJson(resp, Result.ok(null));
    }

    /**
     * 修改新闻
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findHeadlineByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int hid = Integer.parseInt(req.getParameter("hid"));
        NewsHeadline newsHeadline = newsHeadlineService.findHeadlineByHid(hid);
        Map<String,NewsHeadline> data = new HashMap<>();
        data.put("headline",newsHeadline);
        WebUtil.writeJson(resp,Result.ok(data));
    }

    /**
     * 修改内容
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        newsHeadlineService.updateNewsHeadline(newsHeadline);
        WebUtil.writeJson(resp,Result.ok(null));
    }


    protected void removeByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer hid = Integer.parseInt(req.getParameter("hid"));
        newsHeadlineService.removeByHid(hid);
        WebUtil.writeJson(resp,Result.ok(null));

    }
}
