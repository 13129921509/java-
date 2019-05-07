package com.jpa.spring_data_multiple_datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(value = {"com.jpa.spring_data_multiple_datasource.domain.p.repository."})
@SpringBootApplication
public class SpringDataMultipleDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataMultipleDatasourceApplication.class, args);
    }

}

