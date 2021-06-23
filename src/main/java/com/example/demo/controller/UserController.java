package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.mapper.UserMapper3;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/findUser")
    public User findUser(String name,Integer age){
       return   userService.findUser(name,age);
    }
    @Test
    public void test(){
        System.out.println("312");
        System.out.println("3333");


    }
}
