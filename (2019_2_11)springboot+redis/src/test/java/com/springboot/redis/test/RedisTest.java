package com.springboot.redis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void test(){
        RedisSerializer<String> stringRedisSerializer = stringRedisTemplate.getStringSerializer();
        stringRedisTemplate.opsForValue().set("z","1");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }
}
