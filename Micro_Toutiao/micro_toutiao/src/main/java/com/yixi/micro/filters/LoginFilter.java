package com.yixi.micro.filters;

import com.yixi.micro.common.Result;
import com.yixi.micro.common.ResultCodeEnum;
import com.yixi.micro.util.JwtHelper;
import com.yixi.micro.util.WebUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/headline/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String  token = req.getHeader("token");
        if(null != token && !JwtHelper.isExpiration(token)){
            chain.doFilter(request,response);
        }else{
            WebUtil.writeJson(resp, Result.build(null, ResultCodeEnum.NOTLOGIN));
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
