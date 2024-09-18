package org.yixi.manager;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import pojo.User;
import service.UserServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns = {"/login"})
public class LoginSerlvet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问post...");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        StringBuilder requestBody = new StringBuilder();
        String line;

        try (BufferedReader reader = req.getReader()) {
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }

        // 打印请求体用于调试


        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(requestBody.toString(), JsonObject.class);

        String username = jsonObject.get("username").getAsString();
        String password = jsonObject.get("password").getAsString();
//        System.out.println(username+password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);


        UserServiceImpl userService = new UserServiceImpl();
        User u = userService.login(user);

        if(u == null){
            resp.getWriter().print(false);
        }else{
            resp.getWriter().print(true);
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("访问get...");
    }
}