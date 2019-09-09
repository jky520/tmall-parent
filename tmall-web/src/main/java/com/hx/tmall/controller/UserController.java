package com.hx.tmall.controller;

import com.hx.tmall.entity.User;
import com.hx.tmall.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    @GetMapping("/{id}")
    public User show(@PathVariable int id) {
        User user = userService.load(id);
        System.out.println(user.getUsername());
        return user;
    }
}
