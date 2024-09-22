package com.yixi.micro.controller;

import com.yixi.micro.common.Result;
import com.yixi.micro.common.ResultCodeEnum;
import com.yixi.micro.pojo.NewsUser;
import com.yixi.micro.service.NewsUserService;
import com.yixi.micro.service.impl.NewsUserServiceImpl;
import com.yixi.micro.util.JwtHelper;
import com.yixi.micro.util.MD5Util;
import com.yixi.micro.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*")
public class NewsUserController extends BaseController{

    private NewsUserService userService = new NewsUserServiceImpl();

    /**
     * 处理登录表单提交的业务接口的实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受用户名和密码
        NewsUser paramUser = WebUtil.readJson(req, NewsUser.class);

        // 调用 service层的方法 实现登录
        NewsUser loginUser= userService.findByUsername(paramUser.getUsername());

        Result result = null;
        if(loginUser != null){
            // 判断密码对不对
            if(MD5Util.encrypt(paramUser.getUserPwd()).equalsIgnoreCase(loginUser.getUserPwd())){
                Integer uid =  loginUser.getUid();
                String token = JwtHelper.createToken(uid.longValue());
                Map<String,Object> data = new HashMap<>();
                data.put("token",token);
                result = Result.ok(data);
            }else{
                // 密码有误
                result = Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
            }
        }else{
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        // 向客户端响应登录状态
        WebUtil.writeJson(resp,result);
    }

    /**
     * 根据token口令获取用户信息的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // 获取请求体中的token
        String token = req.getHeader("token");
//        System.out.println(req);
//        System.out.println(token);
        Result result = Result.build(null,ResultCodeEnum.NOTLOGIN);
        // 校验token
        if(token != null){
            System.out.println("是否有效"+JwtHelper.isExpiration(token));
            // 是否过期
            if (!JwtHelper.isExpiration(token)) {
                Integer uid = JwtHelper.getUserId(token).intValue();
                NewsUser newsUser =userService.findByUid(uid);
                newsUser.setUserPwd("");
                Map<String,Object> data =new HashMap<>();
                data.put("loginUser",newsUser);
                result=Result.ok(data);
            }
        }
        //响应给客户端
        WebUtil.writeJson(resp,result);

    }
}
