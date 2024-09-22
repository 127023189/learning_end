package com.yixi.micro.controller;

import com.yixi.micro.common.Result;
import com.yixi.micro.pojo.NewsType;
import com.yixi.micro.service.NewsTypeService;
import com.yixi.micro.service.impl.NewsTypeServiceImpl;
import com.yixi.micro.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 门户 控制器
 * 那些不需要登录，不需要做增删改查的门户页面的请求都放在这里
 */
@WebServlet("/portal/*")
public class PortalController extends BaseController{

    private  NewsTypeService typeService = new NewsTypeServiceImpl();

    /**
     * 查询所有头条的业务实现接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询所有的新闻类型，装入Result响应给客户端
        List<NewsType> newsTypeList = typeService.findAll();
        WebUtil.writeJson(resp,Result.ok(newsTypeList));
    }
}
