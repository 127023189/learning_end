package service;

import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.User;
import util.SqlSessionUtil;

public class UserServiceImpl {

    public UserServiceImpl(){}

    public Integer register(User user){
        int row;
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        row = mapper.register(user);
        sqlSession.close();
        return row;
    }
    public User login(User user){
        User u = null;
        try {
            System.out.println("UserImpl 开始");
            SqlSession sqlSession = SqlSessionUtil.getSqlSession();
            System.out.println("获取到sqlSession!!"+sqlSession);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            System.out.println("Mapper 加载成功: " + mapper);
            try {
                u = mapper.login(user);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("UserImpl:"+user + "UserImpl:" + u);
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException("UserImpl");
        }
        System.out.println("UserImp end" + u);
        return u;
    }
}
