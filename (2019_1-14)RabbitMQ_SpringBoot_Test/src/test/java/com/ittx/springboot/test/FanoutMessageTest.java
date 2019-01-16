package com.ittx.springboot.test;

import com.ittx.springboot.controller.fanout.FanoutSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutMessageTest {
    @Autowired
    FanoutSend fanoutSend;
    @Test
    public void test_1(){
        fanoutSend.send();
    }
}
