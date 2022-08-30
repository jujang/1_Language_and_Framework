package com.example.cmarket.user;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepositoryImpl implements UserRepository{
    private static Map<Long, User> users = new HashMap<>();

    @Override
    public void saveUser(User user){
        users.put(user.getId(), user);
    }

    @Override
    public User findByUserId(Long userId){
        return users.get(userId);
    }
}
