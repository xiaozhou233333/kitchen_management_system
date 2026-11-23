package com.example.kitchen_system.service;

import org.springframework.stereotype.Service;

import com.example.kitchen_system.mapper.UserInfoMapper;
import com.example.kitchen_system.model.UserInfo;

@Service 
public class UserService {
    private final UserInfoMapper userInfoMapper;

    public UserService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public UserInfo queryUserByName(String username) {
        return userInfoMapper.queryUserByName(username);
    }
}
