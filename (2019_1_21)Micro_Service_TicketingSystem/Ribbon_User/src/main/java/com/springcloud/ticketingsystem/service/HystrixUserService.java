package com.springcloud.ticketingsystem.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.ticketingsystem.feign_client.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class HystrixUserService {
    @Autowired
    UserFeignClient userFeignClient;
    @RequestMapping("hystrixtest")
    @HystrixCommand(
            fallbackMethod = "fallback",
            threadPoolKey = "test_01",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize",value = "30"),
                    @HystrixProperty(name = "maxQueueSize",value = "10")
            }
    )
    public void hystrixtest(){
        userFeignClient.StringService("hystrix_test");
    }

    public void fallback(){
        System.out.println("Request Error!!!");
    }
}
