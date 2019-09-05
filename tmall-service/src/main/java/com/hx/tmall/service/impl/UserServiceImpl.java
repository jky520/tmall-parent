package com.hx.tmall.service.impl;

import com.hx.tmall.dao.UserDao;
import com.hx.tmall.entity.User;
import com.hx.tmall.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User load(int id) {
        return userDao.load(id);
    }
}
