package com.ittx.springboot.reveice;

import com.ittx.springboot.Entity.Person;
import com.ittx.springboot.staticClass.Constants;
import com.ittx.springboot.util.MailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RabbitListener(queues = Constants.PERSON_TOPIC_SEND_EMAIL_QUEUE_NAME)
public class MailSendReceiver {
    private Logger logger = LoggerFactory.getLogger(MailSendReceiver.class);
    @Autowired
    MailServiceImpl service ;
    @Transactional
    @RabbitHandler
    public void handler(Person person){
        logger.info("邮件发送成功:"+person.getEmail());
        service.sendMail(person.getEmail(),"欢迎加入大家庭","欢迎"+person.getName()+"加入我们!!!");
    }
}
