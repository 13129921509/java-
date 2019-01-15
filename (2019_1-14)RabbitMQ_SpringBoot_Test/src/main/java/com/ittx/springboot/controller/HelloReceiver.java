package com.ittx.springboot.controller;

import com.ittx.springboot.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@RestController
@RequestMapping("/Reveice")
public class HelloReceiver {
    AtomicInteger atomicInteger = new AtomicInteger(0);


    @RabbitListener(queues = "hello")
    public void process(String hello){
        System.out.println("Receiver:"+hello+"……"+atomicInteger.incrementAndGet());
    }

    @RabbitListener(queues = "sendUser")
    @RabbitHandler
    public void process2(User user){
        System.out.println(user.toString());
    }
    @RequestMapping("/hello")
    public String hello(){
        return String.valueOf(atomicInteger);
    }
}
