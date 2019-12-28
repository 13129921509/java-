package com.cai.chatroom.base.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "redis")
public class RedisSetting {
    String host;
    Integer port;
    String password;
    Integer database;
    Integer maxActive;
    Integer maxWait;
    Integer maxIdle;
    Integer timeout;

    //Redssion properties
    String address;
    Integer connectionPoolSize;
}
