package com.jpa.spring_data_multiple_datasource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DatasourceConfiguration {
    @Bean(name = "primaryDatasource")
    @Qualifier("primarydatasource")
    @ConfigurationProperties(prefix = "spring.datasource.primarydatasource")
    public DataSource primarydatasource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "secondDatasource")
    @Qualifier("seconddatasource")
    @ConfigurationProperties(prefix = "spring.datasource.seconddatasource")
    public DataSource seconddatasource(){
        return DataSourceBuilder.create().build();
    }
}
