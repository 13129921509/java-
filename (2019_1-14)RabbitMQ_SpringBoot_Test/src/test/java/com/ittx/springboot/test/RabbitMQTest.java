package com.ittx.springboot.test;

import com.ittx.springboot.controller.HelloSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {
    @Autowired
    HelloSend send;
    CountDownLatch latch = new CountDownLatch(20);
    CountDownLatch latch2 = new CountDownLatch(1);
    Object object = new Object();
//    @Test
//    public void test_0(){
//        ExecutorService service = Executors.newFixedThreadPool(20);
//        for (int i = 0 ; i< 20 ; i++) {
//            service.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        synchronized (object){
//                            latch.await();
//                            System.out.println("等待完毕开始发送……");
//                            latch2.await();
//                            send.send();
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            latch.countDown();
//        }
//        latch2.countDown();
//    }
    @Test
    public void test_1(){
        send.sendUser();
    }

}
