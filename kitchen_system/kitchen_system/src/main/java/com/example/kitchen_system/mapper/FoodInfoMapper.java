package com.example.kitchen_system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.kitchen_system.model.FoodInfo;
import com.example.kitchen_system.model.PageRequest;

@Mapper 
public interface FoodInfoMapper {
    @Select ("select food_nam, count, price, origin, status from food_info")
    List<FoodInfo> getList();

    @Insert ("insert into food_info (food_name, count, price, origin, status) values (#{foodName}, #{count}, #{price}, #{origin}, #{status})")
    Integer insertFood(FoodInfo foodInfo);

    @Select("select count(1) from food_info where status<>0")
    Integer count();

    @Select("select * from food_info where status != 0 order by id desc limit #{offset}, #{pageSize}")
    List<FoodInfo>queryFoodListByPage(PageRequest pageRequest);

    @Update("update food_info set food_name=#{foodName}, count=#{count}, price=#{price}, origin=#{origin}, status=#{status} where id=#{id}")
    Integer updateFood(FoodInfo foodInfo);

    @Update("update food_info set status=0 where id=#{id}")
    Integer deleteFood(Integer id);

    @Update("<script>update food_info set status=0 where id in <foreach collection='ids' item='id' open='(' separator=',' close=')'>#{id}</foreach></script>")
    Integer deleteFoods(@Param("ids") List<Integer> ids);
}
