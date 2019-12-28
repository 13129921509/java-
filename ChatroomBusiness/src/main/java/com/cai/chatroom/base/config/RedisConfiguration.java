package com.cai.chatroom.base.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfiguration {
    @Bean
    RedisSetting redisSetting(){
        RedisSetting setting = new RedisSetting();
        return setting;
    }

    @Bean
    JedisPool jedisPool(RedisSetting setting){
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxWaitMillis(setting.getMaxWait());
        config.setMaxIdle(setting.getMaxIdle());
        config.setMaxTotal(setting.getMaxActive());
        JedisPool pool = new JedisPool(config
                ,setting.getHost()
                ,setting.getPort()
                ,setting.getTimeout()
                ,setting.getPassword().equals("")?null:setting.getPassword()
                ,setting.getDatabase()
        );
        return pool;
    }


}
