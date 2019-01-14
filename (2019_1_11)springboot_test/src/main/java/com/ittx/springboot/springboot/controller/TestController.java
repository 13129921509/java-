package com.ittx.springboot.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("test")
public class TestController {
    AtomicInteger accessNum = new AtomicInteger(0);
    @Autowired
    RedisTemplate redisTemplate;

    ReentrantLock lock = new ReentrantLock();

    @RequestMapping("/del")
    public String hello() {
        Integer su = (Integer) redisTemplate.opsForValue().get("num");
        if (su <= 0) {
            return "库存不足";
        }
        su = su - 1;
        redisTemplate.opsForValue().set("num", su);
        return "实际卖出:" + accessNum.incrementAndGet();
    }

    @RequestMapping("/del2")
    public String del2() {
        redisTemplate.setEnableTransactionSupport(true);
        Object result = redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {

                Object obj = new Object();
                try {
                    lock.lock();
                    redisOperations.watch("num");
                    Integer su = (Integer) redisOperations.opsForValue().get("num");
                    redisOperations.multi();
                    if (su <= 0) {
                        obj = "库存不足";
                    } else {
                        su = su - 1;
                        redisOperations.opsForValue().set("num", su);
                        accessNum.incrementAndGet();
                        obj = redisOperations.exec();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                return obj;
            }

        });
        if (!result.equals("库存不足")) {
            return String.valueOf(redisTemplate.opsForValue().get("num"));
        }
        return String.valueOf(result);
    }

    @RequestMapping("/get")
    public String get() {
        return "当前卖出:" + accessNum.get();
    }

    @RequestMapping("/getRedis")
    public String getRedis() {
        return "仓库存储:" + redisTemplate.opsForValue().get("num");
    }
}
