package com.ittx.springboot.config;




import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {
    @Bean
    public Queue queue(){
        return new Queue("hello");
    }

    @Bean
    public Queue queue2(){
        return new Queue("sendUser");
    }
}
