package com.cai.chatroom.base;

import com.cai.chatroom.base.config.BaseService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPool;

import java.io.Serializable;

public class BaseDomain{

    public String cacheKey;
    public String cacheKeyByUserId;
    public String cacheKeyByUuId;
    protected void setCacheKey(){

    }

    public String getCacheKey(){
        return cacheKey;
    }

    protected  void setCacheKeyByUserId(){

    }

    protected  void setCacheKeyByUuId(){

    }


    public String getCacheKeyByUserId() {
        return cacheKeyByUserId;
    }

    public String getCacheKeyByUuId() {
        return cacheKeyByUuId;
    }
}
