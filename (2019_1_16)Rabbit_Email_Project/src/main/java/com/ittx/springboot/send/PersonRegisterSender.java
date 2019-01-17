package com.ittx.springboot.send;

import com.ittx.springboot.Entity.Person;
import com.ittx.springboot.staticClass.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonRegisterSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Person person){
        rabbitTemplate.convertAndSend(Constants.PERSON_TOPIC_EXCHANGE_NAME,Constants.PERSON_TOPIC_EXCHANGE_ROUTE_KEY,person);
    }
}
