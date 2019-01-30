package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class UserController {
    private Map<String,User> users = new ConcurrentHashMap<String,User>();
    public void setUsers(User users) {
        this.users.put(users.getName(),users);
    }

    @GetMapping(value = "/{name}")
    public User getUser(@PathVariable("name") String name){
        return users.get(name);
    }

    @PostMapping(value = "/")
    public String postUser(@RequestBody Map user){
        User realuser = JSON.parseObject(JSON.toJSONBytes(user),User.class);
        users.put(realuser.getName(),realuser);
        return "success";
    }

    @DeleteMapping(value = "/{name}")
    public String deleteUser(@PathVariable("name") String name){
        users.remove(name);
        return "success";
    }

    @PutMapping()
    public String putUser(@RequestBody String user){
        User realuser = JSON.parseObject(JSON.toJSONBytes(user),User.class);
        users.put(realuser.getName(),realuser);
        return "success";
    }
}
