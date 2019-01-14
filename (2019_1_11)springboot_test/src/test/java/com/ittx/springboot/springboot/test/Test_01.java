package com.ittx.springboot.springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_01 {
    @Autowired
    RedisTemplate redisTemplate;


//    @Test
//    public void test_01(){
//        RedisSerializer redisSerializer = redisTemplate.getStringSerializer();
//        redisTemplate.opsForValue().set("num",20);
//        System.out.println(redisTemplate.opsForValue().get("num"));
//    }

    @Test
    public void test_02(){
        RedisSerializer redisSerializer = redisTemplate.getStringSerializer();
        redisTemplate.opsForValue().set("num",5000);
        System.out.println(redisTemplate.opsForValue().get("num"));
    }
}
