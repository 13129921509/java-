package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "获取用户",notes = "得到ID为{name}的用户")
    @ApiImplicitParam(name = "name",value = "用户的姓名",required = true,dataType = "String")
    @GetMapping(value = "/{name}")
    public User getUser(@PathVariable("name") String name){
        return users.get(name);
    }
    @ApiOperation(value = "创建用户",notes = "创建ID为{name}的用户")
    @ApiImplicitParam(name = "user",value = "创建的用户实体",required = true,dataType = "User")
    @PostMapping(value = "/")
    public String postUser(@RequestBody Map user){
        User realuser = JSON.parseObject(JSON.toJSONBytes(user),User.class);
        users.put(realuser.getName(),realuser);
        return "success";
    }

    @ApiOperation(value = "删除用户",notes = "删除ID为{name}的用户")
    @ApiImplicitParam(name = "name",value = "用户的姓名",required = true,dataType = "String")
    @DeleteMapping(value = "/{name}")
    public String deleteUser(@PathVariable("name") String name){
        users.remove(name);
        return "success";
    }
    @ApiOperation(value = "修改用户",notes = "修改name为{user.name}的用户")
    @ApiImplicitParam(name = "user",value = "修改后的用户实体",required = true,dataType = "User")
    @PutMapping()
    public String putUser(@RequestBody String user){
        User realuser = JSON.parseObject(JSON.toJSONBytes(user),User.class);
        users.put(realuser.getName(),realuser);
        return "success";
    }
}
