package com.springcloud.ticketingsystem.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.ticketingsystem.feign_client.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
//作为默认的Hystrix属性
/**
 * Hystrix设置的3个级别
 * 1.整个应用程序的默认值
 * 2.类默认值
 * 3.类中对特定线程池级别
 */
@DefaultProperties(
        commandProperties = {
                //拥有10秒的超时时间
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000")
        }
)
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
            },
            commandProperties = {
                    //用来指明10秒内，Hystrix用来测试的次数，一定要测试完，加入只测试了9次全部不通过，那么Hystrix依旧判定测试有效
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
                    //用来指定测试不通过的百分比，这里是75%，只要超过这个值 则断定 测试不通过 ，前提完成上面的10次测试
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "75"),
                    //跳闸后 休眠10s 便调用另外的服务来查看是否恢复健康
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000")
            }
    )
    public void hystrixtest(){
        userFeignClient.StringService("hystrix_test");
    }

    public void fallback(){
        System.out.println("Request Error!!!");
    }
}
