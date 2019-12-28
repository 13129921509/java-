package com.cai.chatroom.base.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;


@Configuration
@EnableConfigurationProperties
public class JdbcConfiguration {
//
//    @Autowired
//    JdbcMapSetting jdbcSetting;
    @Bean
    JdbcMapSetting jdbcSetting(){
        return new JdbcMapSetting();
    }

    @Primary
    @Bean
    DataSource dataSource(JdbcMapSetting jdbcSetting){
        JdbcMapSetting.JdbcSetting[] defaultSetting = new JdbcMapSetting.JdbcSetting[1];
        jdbcSetting.getDatasources().forEach((key,value)->{
            if ("true".equals(value.isDefault)){
                defaultSetting[0] = value;
            }
        });
        Assert.notNull(defaultSetting[0],"defaultSetting not null");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(defaultSetting[0].getUsername());
        dataSource.setUrl(defaultSetting[0].url);
        dataSource.setPassword(defaultSetting[0].password);
        dataSource.setMaxActive(defaultSetting[0].maxActive);
        dataSource.setMinIdle(defaultSetting[0].minIdle);
        dataSource.setInitialSize(defaultSetting[0].initialSize);
        dataSource.setMaxIdle(defaultSetting[0].maxIdle);
        dataSource.setDriverClassName(defaultSetting[0].driverClassName);
        return dataSource;
    }

//    @Bean("tx")
//    JpaTransactionManager transactionManager(DataSource dataSource){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setDataSource(dataSource);
//        return transactionManager;
//    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
