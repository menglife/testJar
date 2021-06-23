package com.example.demo.service;

import com.example.demo.entities.User;

public interface UserService {
    public User getUser(Long id);
    public User findUser(String name,Integer age);
}
