package org.example.myblog.service.impl;

import org.example.myblog.Util.Md5Util;
import org.example.myblog.mapper.UserMapper;
import org.example.myblog.pojo.User;
import org.example.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void register(String username, String password) {
        String md5String=Md5Util.getMD5String(password);
        userMapper.register(username,md5String);
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUerName(username);
    }
}
