package com.cai.chatroom.controller;

import com.cai.chatroom.base.genarate.ResponseMessage;
import com.cai.chatroom.base.genarate.ResponseMessageFactory;
import com.cai.chatroom.constants.UserMessage;
import com.cai.chatroom.entity.User;
import com.cai.chatroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResponseMessage login(HttpServletRequest request, @RequestBody User user){
        return userService.login(request,user);
    }

    @RequestMapping(value = "existUser",method = RequestMethod.POST)
    public ResponseMessage existUser(HttpServletRequest request, @RequestBody User user){
        if (user.getUsername() == null){
            return ResponseMessageFactory.error(UserMessage.UM_0006);
        }
        return userService.existUser(request,user);
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ResponseMessage registerUser(HttpServletRequest request, @RequestBody User user){
        return userService.register(request,user);
    }
}
