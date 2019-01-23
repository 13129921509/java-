package com.springcloud.ticketingsystem.controller;

import com.springcloud.ticketingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping("rabbion-user-register")
    public String getUser(){
        return service.getUser();
    }
}
