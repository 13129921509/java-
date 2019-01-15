package com.ittx.springboot.controller;

import com.ittx.springboot.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Component
public class HelloSend {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String content = "hello "+new Date();
        System.out.println("sender:"+content);
        amqpTemplate.convertAndSend("hello",content);
    }

    public void sendUser(){
        String content = "hello "+new Date();
        System.out.println("sender:"+content);
        User user =  new User("cai",12);
        amqpTemplate.convertAndSend("sendUser",user);
    }


}
