package com.school.springbootandmybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//该项目做到了不用任何的xml文件就可以使用mybatis+springboot+事务回滚
@SpringBootApplication
public class SpringbootandmybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootandmybatisApplication.class, args);
	}
}
