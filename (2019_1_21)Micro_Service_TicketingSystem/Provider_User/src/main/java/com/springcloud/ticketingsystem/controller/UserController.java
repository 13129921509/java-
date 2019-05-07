package com.springcloud.ticketingsystem.controller;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.springcloud.ticketingsystem.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class UserController{
    Logger logger = Logger.getLogger(UserController.class);
    @Qualifier("eurekaClient")
    @Autowired
    EurekaClient eurekaClient;
    @Autowired
    DiscoveryClient client;

    @RequestMapping(value = "/eurekaClient",method = RequestMethod.GET)
    public Map getEurekaClient(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("user-register-server",false);
        //ServiceInstance instance = client.getLocalServiceInstance();
        logger.info(instance.getIPAddr());
        return instance.getMetadata();
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        ServiceInstance instance = client.getLocalServiceInstance();
        return "user:"+instance.getHost()+","+instance.getServiceId();
    }

    @RequestMapping(value = "/message",method = RequestMethod.GET)
    public String getMessage() throws InterruptedException {
//        Thread.sleep(2000);
        User user = new User("蔡子文","22");
        return user.toString();
    }
}
