package com.ittx.springboot.test;

import com.ittx.springboot.Entity.Person;
import com.ittx.springboot.send.PersonRegisterSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterAndSendTest {
    @Autowired
    PersonRegisterSender sender;

    @Test
    public void test(){
        sender.sendMessage(new Person("蔡子文","942445346@qq.com"));
    }
}
