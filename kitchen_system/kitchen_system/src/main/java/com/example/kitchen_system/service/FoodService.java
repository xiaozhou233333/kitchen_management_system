package com.example.kitchen_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kitchen_system.mapper.FoodInfoMapper;
import com.example.kitchen_system.model.FoodInfo;
import com.example.kitchen_system.model.FoodStatus;
import com.example.kitchen_system.model.PageRequest;
import com.example.kitchen_system.model.PageResult;

@Service
public class FoodService {
    private final FoodInfoMapper foodInfoMapper;

    FoodService(FoodInfoMapper foodInfoMapper) {
        this.foodInfoMapper = foodInfoMapper;
    }

    public List<FoodInfo> getList() {
        List<FoodInfo> foods = foodInfoMapper.getList();

        return foods;
    }

    public void addFood(FoodInfo foodInfo) {
        foodInfoMapper.insertFood(foodInfo);
    }

    public PageResult<FoodInfo> getFoodListByPage(PageRequest pageRequest) {
        Integer count = foodInfoMapper.count();
        List<FoodInfo> foods = foodInfoMapper.queryFoodListByPage(pageRequest);
        for (FoodInfo food: foods) {
            food.setStatusCN(FoodStatus.getNameByCode(food.getStatus()).getName());
        }
        
        return new PageResult<>(count, foods);
    }

    public void updateFood(FoodInfo foodInfo) {
        foodInfoMapper.updateFood(foodInfo);
    }

    public void deleteFood(Integer id) {
        foodInfoMapper.deleteFood(id);
    }

    public void deleteFoods(List<Integer> ids) {
        foodInfoMapper.deleteFoods(ids);
    }
}
