package com.ittx.springboot.controller.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class TopicMessageReceiver2 {
    @RabbitHandler
    public void receiver2(String content){
        System.out.println("receiver2"+content);
    }
}
