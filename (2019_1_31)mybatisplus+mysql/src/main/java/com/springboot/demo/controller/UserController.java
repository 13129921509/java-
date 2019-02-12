package com.springboot.demo.controller;

import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("user/{id}")
    public String setVersion(@PathVariable("id") Integer id){
        return service.setUsersetVersion(id,service.getUsersetVersion(id));
    }
}
