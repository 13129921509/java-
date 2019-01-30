package com.springcloud.ticketingsystem.controller;

import com.netflix.ribbon.proxy.annotation.Http;
import com.springcloud.ticketingsystem.entity.User;
import com.springcloud.ticketingsystem.feign_client.UserFeignClient;
import com.springcloud.ticketingsystem.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {
    Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    UserFeignClient userFeignClient;
    @Autowired
    UserService service;
    @Autowired
    RestTemplate restTemplate;
    private DiscoveryClient discoveryClient;
    @RequestMapping("rabbion-user-register")
    public String getUser(){
        String user = userFeignClient.StringService("message");
        return "Feign:"+user.toString();
    }
    @RequestMapping("rabbion-user-register2")
    public String getUser2() throws InterruptedException {
        logger.info("-----------------断路器测试--------------");
        return "Htstrix:"+service.getUser();
    }
    @GetMapping("rabbion-message-register")
    public String getMessage(){
        String user = restTemplate.getForEntity("http://user-register-server/user",String.class).getBody();
        return "Feign:"+user;
    }

    @GetMapping("instance")
    public String getInstance(){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("USER-REGISTER-SERVER");
        if(instanceList.size()==0) return null;
//        String serviceUrl = String.format()
        String instance ="http://"+ ((EurekaDiscoveryClient.EurekaServiceInstance) instanceList.get(0)).getInstanceInfo().getVIPAddress()+"/user";
        ResponseEntity<String> entity = restTemplate.exchange(instance,HttpMethod.GET,null,String.class);
        return entity.getBody();
    }
}
