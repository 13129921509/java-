package com.ittx.springboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {
    final static String messgae = "topic.message";
    final static String messgaes = "topic.messages";

    @Bean("message")
    public Queue queueMessage(){
        return new Queue(TopicRabbitConfig.messgae);
    }

    @Bean("messages")
    public Queue queueMessages(){
        return new Queue(TopicRabbitConfig.messgaes);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier(value = "message") Queue queueMessage, TopicExchange exchange){
       return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier(value = "messages") Queue queueMessages,TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.messages");
    }
}
