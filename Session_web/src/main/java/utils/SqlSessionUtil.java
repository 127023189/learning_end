package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/*
    工具类特点：
        1.位于util包
        2.私有化构造方法
        3.提供静态方法
 */
public class SqlSessionUtil {
    private static SqlSessionFactory factory = null;

    //2.私有化构造方法 目的：不能创建对象，使用类名调用本类静态方法
    private SqlSessionUtil() {
    }

    //定义静态代码块：当前类加载就执行，之后执行一次
    static {
        try {
            //1.创建工厂创造类对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //2.获取工厂对象
            factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //编写静态方法获取会话对象，设置自动提交事务
    public static SqlSession getSqlSession() {
        //1.根据会话工厂对象获取会话对象
        SqlSession sqlSession = factory.openSession(true);
        //2.返回会话对象
        return sqlSession;
    }

    //编写静态方法获取会话对象，方法接收调用者传递的参数是布尔类型，决定是否设置自动提交事务
    public static SqlSession getSqlSession(boolean isAutoCommit) {
        //1.根据会话工厂对象获取会话对象
        SqlSession sqlSession = factory.openSession(isAutoCommit);
        //2.返回会话对象
        return sqlSession;
    }

    //编写静态方法接收会话对象，手动提交事务并且关闭会话
    public static void commitAndClose(SqlSession sqlSession) {
        //防止空指针异常
        if (sqlSession != null) {
            //1.手动提交事务
            sqlSession.commit();
            //2.释放资源
            sqlSession.close();
        }

    }

    //编写静态方法接收会话对象，回滚事务并且关闭会话
    public static void rollbackAndClose(SqlSession sqlSession) {
        //防止空指针异常
        if (sqlSession != null) {
            //1.回滚事务
            sqlSession.rollback();
            //2.释放资源
            sqlSession.close();
        }
    }
}
