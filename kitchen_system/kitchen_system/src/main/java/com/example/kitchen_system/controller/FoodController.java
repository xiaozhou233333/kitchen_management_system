package com.example.kitchen_system.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kitchen_system.model.FoodInfo;
import com.example.kitchen_system.model.PageRequest;
import com.example.kitchen_system.model.PageResult;
import com.example.kitchen_system.service.FoodService;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
    

    @RequestMapping("/getList")
    public List<FoodInfo> getList() {
        List<FoodInfo> foods = foodService.getList();
        return foods;
    }

    @RequestMapping("/addFood")
    public String addFood(FoodInfo foodInfo) {
        log.info("added food: {}", foodInfo);
        if (!StringUtils.hasLength(foodInfo.getFoodName()) ||
            !StringUtils.hasLength(foodInfo.getOrigin()) ||
            foodInfo.getCount() == null ||
            foodInfo.getPrice() == null ||
            foodInfo.getStatus() == null) {
                return "wrong params!";
        }
        try {
            foodService.addFood(foodInfo);
            return "";
        } catch (Exception e) {
            log.error("failed to add food", e);
            return e.getMessage();
        }
    }

    @RequestMapping("/getListByPage")
    public PageResult<FoodInfo> getListByPage(PageRequest pageRequest) {
        log.info("Got food list: {}", pageRequest);
        PageResult<FoodInfo> pageResult = foodService.getFoodListByPage(pageRequest);
        return pageResult;
    }

    @RequestMapping("/updateFood")
    public String updateFood(FoodInfo foodInfo) {
        log.info("update food: {}", foodInfo);
        if (foodInfo.getId() == null ||
            !StringUtils.hasLength(foodInfo.getFoodName()) ||
            !StringUtils.hasLength(foodInfo.getOrigin()) ||
            foodInfo.getCount() == null ||
            foodInfo.getPrice() == null ||
            foodInfo.getStatus() == null) {
            return "wrong params!";
        }
        try {
            foodService.updateFood(foodInfo);
            return "";
        } catch (Exception e) {
            log.error("failed to update food", e);
            return e.getMessage();
        }
    }

    @RequestMapping("/deleteFood")
    public String deleteFood(Integer id) {
        log.info("delete food id: {}", id);
        if (id == null) {
            return "wrong params!";
        }
        try {
            foodService.deleteFood(id);
            return "";
        } catch (Exception e) {
            log.error("failed to delete food", e);
            return e.getMessage();
        }
    }

    @RequestMapping("/deleteFoods")
    public String deleteFoods(String ids) {
        log.info("delete foods ids: {}", ids);
        if (!StringUtils.hasLength(ids)) {
            return "wrong params!";
        }
        try {
            List<Integer> idList = Arrays.stream(ids.split(","))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
            foodService.deleteFoods(idList);
            return "";
        } catch (Exception e) {
            log.error("failed to delete foods", e);
            return e.getMessage();
        }
    }
}
