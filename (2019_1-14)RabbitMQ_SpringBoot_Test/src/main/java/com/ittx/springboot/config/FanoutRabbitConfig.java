package com.ittx.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {
    @Bean
    public Queue queueA(){
        return new Queue("queueA");
    }

    @Bean
    public Queue queueB(){
        return new Queue("queueB");
    }

    @Bean
    public Queue queueC(){
        return new Queue("queueC");
    }
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding bindingQueueA(Queue queueA, FanoutExchange exchange){
        return BindingBuilder.bind(queueA).to(exchange);
    }

    @Bean
    public Binding bindingQueueB(Queue queueB, FanoutExchange exchange){
        return BindingBuilder.bind(queueB).to(exchange);
    }

    @Bean
    public Binding bindingQueueC(Queue queueC, FanoutExchange exchange){
        return BindingBuilder.bind(queueC).to(exchange);
    }
}
