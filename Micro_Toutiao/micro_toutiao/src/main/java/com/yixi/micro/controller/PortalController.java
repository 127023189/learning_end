package com.yixi.micro.controller;

import javax.servlet.annotation.WebServlet;

/**
 * 门户 控制器
 * 那些不需要登录，不需要做增删改查的门户页面的请求都放在这里
 */
@WebServlet("/portal/*")
public class PortalController extends BaseController{
}
