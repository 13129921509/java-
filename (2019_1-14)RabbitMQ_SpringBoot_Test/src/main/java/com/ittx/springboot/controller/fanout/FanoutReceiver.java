package com.ittx.springboot.controller.fanout;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {
    @RabbitListener(queues = "queueA")
    public void receiver1(String message){
        System.out.println("receiver1:"+message);
    }

    @RabbitListener(queues = "queueB")
    public void receiver2(String message){
        System.out.println("receiver2:"+message);
    }

    @RabbitListener(queues = "queueC")
    public void receiver3(String message){
        System.out.println("receiver3:"+message);
    }
}
