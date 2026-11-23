package com.example.kitchen_system.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class FoodInfo {
    private Integer id;
    private String foodName;
    private Integer count;
    private BigDecimal price;
    private String origin;
    private Integer status;
    private String statusCN;
    private Date createTime;
    private Date updateTime;
}
