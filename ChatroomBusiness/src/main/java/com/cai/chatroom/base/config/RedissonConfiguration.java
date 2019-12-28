package com.cai.chatroom.base.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class RedissonConfiguration {

    @Bean
    RedissonClient redisClientSingle(RedisSetting redisSetting){
        Config config = new Config();
        if (redisSetting.getHost() != null && redisSetting.getPort() != null) {
            redisSetting.setAddress("redis://" + redisSetting.getHost() + ":" + redisSetting.getPort());
        }
        SingleServerConfig singleServerConfig = config.useSingleServer()
                .setAddress(redisSetting.getAddress())
                .setTimeout(redisSetting.getTimeout())
                .setConnectionPoolSize(redisSetting.getConnectionPoolSize())
                .setPassword(redisSetting.getPassword().equals("")?null:redisSetting.getPassword());
        return Redisson.create(config);
    }
}
