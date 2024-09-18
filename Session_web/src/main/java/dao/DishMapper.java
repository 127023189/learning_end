package dao;

import org.apache.ibatis.annotations.Insert;
import pojo.Dish;

public interface DishMapper {

    @Insert("insert into dish values(null,#{name},#{price},#{description})")
    public void addDish(Dish dish);
}
