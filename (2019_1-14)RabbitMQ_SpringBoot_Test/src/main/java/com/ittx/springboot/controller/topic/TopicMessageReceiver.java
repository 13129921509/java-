package com.ittx.springboot.controller.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")
public class TopicMessageReceiver {
    @RabbitHandler
    public void receiver1(String content){
        System.out.println("receiver"+content);
    }
}
