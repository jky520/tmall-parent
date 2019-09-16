package com.hx.tmall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hx.tmall.entity.User;
import com.hx.tmall.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserDubboController {

    @Reference
    private UserService userService;

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable int id) {
        return userService.load(id);
    }
}
