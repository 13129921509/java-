package com.springcloud.ticketingsystem.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserError")
    public String getUser(){
        /**
         * 假设在这里打断点 那么必定会线程等待 那么不管接下来你怎么继续下去 都会熔断 导致服务不可用
         */
        String u = restTemplate.getForEntity("http://user-register-server/user",String.class).getBody();
        return u;
    }

    public String getUserError(){
        return "get User Error!!!";
    }
}
