package com.school.redis_cluster.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_01 {
    @Autowired
    RedisTemplate redisTemplate;

    ValueOperations<String,String> stringRedis;
    ValueOperations<String,List> hashRedis;
    @Test
    public void test_01(){
        stringRedis = redisTemplate.opsForValue();
        List list  = new ArrayList();
        list.add("caiziwen");
        list.add("22");
        stringRedis.set("my","cai");
        System.out.println(stringRedis.get("my"));
    }

    @Test
    public void test_02(){
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer serializer = redisTemplate.getStringSerializer();
                redisConnection.lPush(serializer.serialize("num"),serializer.serialize("22"));
                redisConnection.lPush(serializer.serialize("num"),serializer.serialize("122"));
                System.out.println(redisConnection.lRange(serializer.serialize("num"),1,2).get(0));
                List<byte[]> list = redisConnection.lRange(serializer.serialize("num"),1,2);
                System.out.println(serializer.deserialize(list.get(0)));
                return null;
            }
        });
    }
}
