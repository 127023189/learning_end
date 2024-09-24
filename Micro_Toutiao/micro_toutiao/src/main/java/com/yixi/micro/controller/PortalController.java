package com.yixi.micro.controller;

import com.yixi.micro.common.Result;
import com.yixi.micro.pojo.NewsHeadline;
import com.yixi.micro.pojo.NewsType;
import com.yixi.micro.pojo.vo.HeadlineDetailVo;
import com.yixi.micro.pojo.vo.HeadlineQueryVo;
import com.yixi.micro.service.NewsHeadlineService;
import com.yixi.micro.service.NewsTypeService;
import com.yixi.micro.service.impl.NewsHeadlineServiceImpl;
import com.yixi.micro.service.impl.NewsTypeServiceImpl;
import com.yixi.micro.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门户 控制器
 * 那些不需要登录，不需要做增删改查的门户页面的请求都放在这里
 */
@WebServlet("/portal/*")
public class PortalController extends BaseController{

    private  NewsTypeService typeService = new NewsTypeServiceImpl();
    private NewsHeadlineService headlineService= new NewsHeadlineServiceImpl();

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

    /**
     * 分页查询新闻
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        HeadlineQueryVo headLineQueryVo = WebUtil.readJson(req, HeadlineQueryVo.class);
        Map<String,Object> pageInfo = headlineService.findPage(headLineQueryVo);
        Map<String,Object> pageInfomap = new HashMap<>();
        pageInfomap.put("pageInfo",pageInfo);

        WebUtil.writeJson(resp,Result.ok(pageInfomap));
    }

    /**
     * 查询单个新闻的内容
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer hid = Integer.parseInt(req.getParameter("hid"));

         HeadlineDetailVo headlineDetailVo = headlineService.findHeadlineDetail(hid);
         Map data = new HashMap();
         data.put("headline",headlineDetailVo);

         //响应JSON
        WebUtil.writeJson(resp,Result.ok(data));
    }
}
