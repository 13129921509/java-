package com.cai.chatroom.base.config;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;

@Component
public class RedisService {
    @Autowired
    JedisPool jedisPool;

    public Jedis jedis;

    @PostConstruct
    void init(){
         jedis = (Jedis) jedisPool.getResource();
    }

    Jedis getJedis(){
        return jedis;
    }

    public static String serialize(Object object) {
        String getString = JSON.toJSONString(object);
        return getString;
    }

    public static <T> T unSerialize(String jsonString,Class<T> clazz) {
        T jsonObject = JSON.parseObject(jsonString,clazz);
        return jsonObject;
    }
}
