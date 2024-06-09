package org.example.myblog.service;

import org.example.myblog.pojo.User;

public interface UserService {
    void register(String username, String password);

    User findByUserName(String username);
}
