package com.ittx.springcloud.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Component;

/**
 * 作为中间件的健康监测类
 */
@Component
public class RabbitMQHealthIndication implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check();
        if(!(errorCode == 0)){
            return Health.down().withDetail("errorCode","errorCode").build();
        }
        return Health.up().build();
    }

    public int check(){
        return 0;
    }
}
