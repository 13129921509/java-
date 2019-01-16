package com.ittx.springboot.test;

import com.ittx.springboot.controller.topic.TopicMessageSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicMessageTest {
    @Autowired
    TopicMessageSend send;
    @Test
    public void test_0(){
        send.sendMessage();
    }
}
