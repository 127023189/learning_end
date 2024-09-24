package com.yixi.micro.filters;

import javax.servlet.*;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 跨域过滤器
 * 后端做跨域处理，防止前端没有进行代理处理
 */

@WebFilter("/*")
public class CrosFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        response.setHeader("Access-Control-Allow-Origin", "*"); //  表示允许所有源（即任何域名）访问
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, HEAD"); // 指定允许哪些 HTTP 方法（请求方式）可以跨域访问
        response.setHeader("Access-Control-Max-Age", "3600");// 这行设置了预检请求（OPTIONS 请求）的缓存时间
        //这里设置了允许在请求中使用的自定义请求头字段
        response.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin, authority, content-type, version-info, X-Requested-With");
        // 非预检请求,放行即可,预检请求,则到此结束,不需要放行
        if(!request.getMethod().equalsIgnoreCase("OPTIONS")){
            filterChain.doFilter(servletRequest, servletResponse);
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