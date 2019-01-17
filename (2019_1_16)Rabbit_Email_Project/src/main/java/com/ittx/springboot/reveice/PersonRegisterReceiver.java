package com.ittx.springboot.reveice;

import com.ittx.springboot.Entity.Person;
import com.ittx.springboot.dao.PersonRepository;
import com.ittx.springboot.staticClass.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RabbitListener(queues = Constants.PERSON_TOPIC_REGISTER_QUEUE_NAME)
public class PersonRegisterReceiver {
    @Autowired
    private PersonRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonRegisterReceiver.class);

    @RabbitHandler
    @Transactional
    public void handler(Person person){
        logger.info("会员用户名: {}, 注册成功, 准备创建会员信息...", person.getName());
        repository.save(person);
    }
}
