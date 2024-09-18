package org.yixi.manager;

import com.google.gson.Gson;
import pojo.User;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问get.....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问post.....");

        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");

        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while((line=reader.readLine()) !=null){
            sb.append(line);
        }
        System.out.println("请求数据"+sb);

        Gson gson = new Gson();
        User user = gson.fromJson(sb.toString(), User.class);
        System.out.println("json:"+user);

        UserServiceImpl userService = new UserServiceImpl();
        User login = userService.login(user);
        if(login != null){
            resp.getWriter().print(false);
            System.out.println("已存在无法注册！！");
            return;
        }
        Integer row = userService.register(user);
        if(row > 0){
            resp.getWriter().print(true);
        }else{
            resp.getWriter().print(false); // 注册失败
        }
    }
}
