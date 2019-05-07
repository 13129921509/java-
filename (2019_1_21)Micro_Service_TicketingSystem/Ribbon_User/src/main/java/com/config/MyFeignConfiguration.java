package com.config;

import feign.Contract;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFeignConfiguration {
    @Bean
    public Contract feignConfiguration(){
        return new Contract.Default();
    }
}
