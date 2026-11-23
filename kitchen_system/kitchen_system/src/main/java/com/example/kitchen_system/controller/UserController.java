package com.example.kitchen_system.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kitchen_system.model.UserInfo;
import com.example.kitchen_system.service.UserService;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/login")
    public boolean login(String username, String password, HttpSession session) {
        if (!StringUtils.hasLength(username) ||   
            !StringUtils.hasLength(password)) {
            return false;
        }

        UserInfo userInfo = userService.queryUserByName(username);
        if (userInfo == null) {
            return false;
        }

        if (password.equals(userInfo.getPassword())) {
            userInfo.setPassword("");
            session.setAttribute("session_user_key", userInfo);
            return true;
        }

        return false;
    }
}
