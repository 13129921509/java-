package com.school.springboot.controller;

import com.school.springboot.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(){
        return "hello world!";
    }
    @RequestMapping("/user")
    public User getUser(){
        User user = new User();
        user.setName("cai");
        user.setSex("men");
        return user;
    }
}
