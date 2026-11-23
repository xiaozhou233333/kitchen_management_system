package com.example.kitchen_system.model;

import java.util.List;

import lombok.Data;

@Data 
public class PageResult<T> {
    private int total;
    private List<T> records;

    public PageResult(Integer total, List<T> records) {
        this.total = total;
        this.records = records;
    }
}
