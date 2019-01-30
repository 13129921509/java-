package com.springcloud.ticketingsystem.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.ticketingsystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.springcloud.ticketingsystem.ribbionconfig.UserRabbionConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@Configuration
@Service
@RibbonClient(name = "USER-REGISTER-SERVER",configuration = UserRabbionConfig.class)
public class UserService {

    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "getUserError")
    public String getUser() throws InterruptedException {
        /**
         * 假设在这里打断点 那么必定会线程等待 那么不管接下来你怎么继续下去 都会熔断 导致服务不可用
         */
        if(new Random().nextInt(2) == 1){
            Thread.sleep(1000);
        }
        String u = restTemplate.getForEntity("http://user-register-server/user",String.class).getBody();
//        String u = userFeignClient.getUserService("user");
        return u;
    }
    public String getUserError(){
        List<User> fallbackList = new ArrayList<User>();
        User user = new User()
                .withName("蔡子文")
                .withAge("22");
        fallbackList.add(user);
        return "fallback:"+fallbackList.toString();
    }
    public String getUserError2(){
        return "Request Error!!!";
    }
}
