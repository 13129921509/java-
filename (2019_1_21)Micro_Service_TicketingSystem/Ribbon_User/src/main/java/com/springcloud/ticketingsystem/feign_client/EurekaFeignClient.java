package com.springcloud.ticketingsystem.feign_client;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sss",url = "localhost:9002",configuration = com.config.MyFeignConfiguration.class)
public interface EurekaFeignClient {
    @RequestLine(value = "GET /{service}")
    //@RequestMapping(value = "{service}",method = RequestMethod.GET)
    String getStatus(@Param(value = "service") String service);
}
