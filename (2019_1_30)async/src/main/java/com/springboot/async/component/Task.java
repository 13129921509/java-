package com.springboot.async.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Task {
    AtomicInteger flog = new AtomicInteger(3);

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Async("cai_executor")
    public Future<String> task1() throws InterruptedException {
        System.out.println("任务1开始");
        Thread.sleep(2000);
        stringRedisTemplate.randomKey();
        flog.decrementAndGet();
        return new AsyncResult<>("任务1结束");
    }
    @Async("cai_executor")
    public Future<String> task2() throws InterruptedException {
        System.out.println("任务2开始");
        Thread.sleep(1000);
        flog.decrementAndGet();
        return new AsyncResult<>("任务2结束");
    }
    @Async("cai_executor")
    public Future<String> task3() throws InterruptedException {
        System.out.println("任务3开始");
        Thread.sleep(1000);
        flog.decrementAndGet();
        return new AsyncResult<>("任务3结束");
    }
    @Async("cai_executor")
    public Future<Boolean> inFinish() throws InterruptedException {
        while(true){
            if(flog.get()==0){
                break;
            }
        }
        return new AsyncResult<>(false);
    }
    @Async("cai_executor")
    public void task4() throws InterruptedException {
        System.out.println("任务1开始");
//        Thread.sleep(2000);
        stringRedisTemplate.randomKey();
    }
    @Async("cai_executor")
    public void task5() throws InterruptedException {
        System.out.println("任务2开始");
//        Thread.sleep(2000);
        stringRedisTemplate.randomKey();
    }

    @Async("cai_executor")
    public void task6() throws InterruptedException {
        System.out.println("任务3开始");
//        Thread.sleep(2000);
        stringRedisTemplate.randomKey();
    }
}
