package com.ittx.springboot.controller.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicMessageSend {
    @Autowired
    AmqpTemplate rabbitTemplate;

    public void sendMessage(){
        rabbitTemplate.convertAndSend("exchange","topic.message","今天是个好日子");
    }

    public void sendMessages(){
        rabbitTemplate.convertAndSend("exchange","topic.messages","今天是个好日子!!!");
    }
}
