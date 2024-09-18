package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import pojo.User;

public interface UserMapper {
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(User user);

    @Insert("insert into  user values(null,#{username},#{password})")
    Integer register(User user);
}
