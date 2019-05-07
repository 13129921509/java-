package com.springboot.async.test;

import com.springboot.async.component.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTest {
    @Autowired
    Task task;
    @Test
    public void test() throws InterruptedException, ExecutionException {
        Long start = System.currentTimeMillis();
        for(int i = 0 ; i < 999 ; i++){
            task.task4();
            task.task5();
            task.task6();
            if(i == 998){
                System.exit(0);
            }
        }
//        Future<Boolean> t4 = task.inFinish();
//        while(true){
//            if(t4.get() == false){
//                break;
//            }
//        }
//        Long end = System.currentTimeMillis();
//        System.out.println("共消耗:"+(end-start));
//
//        while(true){
//            System.out.println(Thread.activeCount());
//        }
    }
}
