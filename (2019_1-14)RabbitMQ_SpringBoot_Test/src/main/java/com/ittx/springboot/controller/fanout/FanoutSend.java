package com.ittx.springboot.controller.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSend {
    @Autowired
    AmqpTemplate rabbitTemplate;
    public void send(){
        rabbitTemplate.convertAndSend("fanoutExchange","","all ting!!!");
    }
}
