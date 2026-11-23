package com.example.kitchen_system.model;

public enum FoodStatus {
    DELETED(0, "无效"),
    NORMAL(1, "正常"),
    OUTDATED(2, "过期");
    
    private Integer code;
    private String name;

    FoodStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static FoodStatus getNameByCode(Integer code) {
        switch(code) {
            case 0: return DELETED;
            case 1: return NORMAL;
            case 2: return OUTDATED;
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
