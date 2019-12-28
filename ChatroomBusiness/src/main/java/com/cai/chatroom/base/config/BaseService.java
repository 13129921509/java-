package com.cai.chatroom.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
public class BaseService<T> {

    JdbcTemplate jdbcTemplate;
    Jedis jedis;
    @Autowired
    DataSource dataSource;

    @Autowired
    RedisService redisService;

    @Autowired
    RedisLockService redisLockService;

    @PostConstruct
    public void init(){
        jdbcTemplate = new JdbcTemplate(dataSource);
        jedis = redisService.getJedis();
    }

    public JdbcTemplate template(){
        return jdbcTemplate;
    }

    public Jedis jedis() {
        return jedis;
    }

    public RedisLockService redisLock(){
        return redisLockService;
    }
}
