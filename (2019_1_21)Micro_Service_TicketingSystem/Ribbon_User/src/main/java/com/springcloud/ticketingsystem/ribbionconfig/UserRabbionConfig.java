package com.springcloud.ticketingsystem.ribbionconfig;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class UserRabbionConfig {
//    @Value("${ribbon.client.name}")
//    private String client = "client";
//    @Bean
//    public IClientConfig clientConfig(){
//        DefaultClientConfigImpl config =  new DefaultClientConfigImpl();
//        config.loadProperties(client);
//        return config;
//    }
//    @Bean
//    public IPing ribbonPing(IClientConfig config){
//        return new PingUrl();
//    }
////    @Bean
////    public ServerList ribbionServerList(){
////        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
////        serverList.initWithNiwsConfig(clientConfig());
////        return serverList;
////    }

    @Bean
    public IRule myRule(){
        //return new RoundRobinRule();//轮询
        //return new RetryRule();//重试
        return new BestAvailableRule();
    }
}
