package com.hx.tmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hx.tmall.dao.UserDao;
import com.hx.tmall.entity.User;
import com.hx.tmall.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Service(timeout = 1200000)
@Component
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User load(int id) {
        User user = userDao.load(id);
        return user;
    }
}
