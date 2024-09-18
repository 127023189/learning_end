package org.yixi;


import dao.DishMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Dish;
import utils.SqlSessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addDishServlet"})
public class addDishServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String description = req.getParameter("description");

        Dish dish = new Dish();
        dish.setName(name);
        dish.setPrice(Double.parseDouble(price));
        dish.setDescription(description);

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DishMapper mapper = sqlSession.getMapper(DishMapper.class);
        mapper.addDish(dish);

        resp.getWriter().print("success");

    }
}
