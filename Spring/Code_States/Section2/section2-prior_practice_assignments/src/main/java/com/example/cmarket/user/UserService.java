package com.example.cmarket.user;

public interface UserService {

    void signup(User user);
    User findUser(Long userId);
}
