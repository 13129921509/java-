package com.springcloud.ticketingsystem.controller;

import com.springcloud.ticketingsystem.feign_client.EurekaFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController {
    @Autowired
    private EurekaFeignClient client;

    @RequestMapping(value = "getEureka/{service}",method = RequestMethod.GET)
    public String getStatus(@PathVariable String service){
        return client.getStatus(service);
    }
}
