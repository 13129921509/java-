package com.ittx.springboot.config;

import com.ittx.springboot.staticClass.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PersonRegisterConfiguration {

    private static Logger logger = LoggerFactory.getLogger(PersonRegisterConfiguration.class);

    /**
     * @return 注册会员交换机实例
     */
    @Bean(name = "exchange")
    public TopicExchange exchange(){
        TopicExchange exchange = new TopicExchange(Constants.PERSON_TOPIC_EXCHANGE_NAME);
        logger.info("【成员注册交换机成功创建！！！】");
        return exchange;
    }
    /**
     * @return 注册会员队列实例
     */
    @Bean(name = "registerQueue")
    public Queue registerQueue(){
        Queue queue = new Queue(Constants.PERSON_TOPIC_REGISTER_QUEUE_NAME,true);
        logger.info("【成员注册队列成功创建！！！】");
        return queue;
    }
    /**
     * @return 会员邮件发送队列实例
     */
    @Bean(name = "sendMailQueue")
    public Queue sendMailQueue(){
        Queue queue = new Queue(Constants.PERSON_TOPIC_SEND_EMAIL_QUEUE_NAME,true);
        logger.info("【成员邮件发送队列成功创建！！！】");
        return queue;
    }

    /**
     * @return 注册会员队列绑定
     */
    @Bean
    public Binding personRegisterBinding(@Qualifier("registerQueue") Queue queue,@Qualifier("exchange") TopicExchange exchange){
        Binding binding = BindingBuilder.bind(queue).to(exchange).with(Constants.PERSON_TOPIC_REGISTER_QUEUE_ROUTE_KEY);
        logger.info("【成员注册队列与交换机成功绑定！！！】");
        return binding;
    }

    /**
     * @return  发送邮件队列绑定
     */
    @Bean
    public Binding sendMailBinding(@Qualifier("sendMailQueue") Queue queue,@Qualifier("exchange") TopicExchange exchange){
        Binding binding = BindingBuilder.bind(queue).to(exchange).with(Constants.PERSON_TOPIC_SEND_EMAIL_QUEUE_ROUTE_KEY);
        logger.info("【成员邮件发送队列与交换机成功绑定！！！】");
        return binding;
    }
}
