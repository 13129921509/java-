package com.springcloud.ticketingsystem.feign_client;

import com.springcloud.ticketingsystem.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Component
@FeignClient("USER-REGISTER-SERVER")
public interface UserFeignClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "{service}",
            consumes = "application/json"
    )
    String StringService(@PathVariable("service") String service);
//
//    @RequestMapping(
//            method = RequestMethod.GET,
//            value = "{service}",
//            consumes = "application/json"
//    )
//    String StringService(@PathVariable("service") String service);
}
