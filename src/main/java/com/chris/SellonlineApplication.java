package com.chris;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages="com.chris.pojo.mapper")
@EnableCaching
public class SellonlineApplication {
	public static void main(String[] args) {
		SpringApplication.run(SellonlineApplication.class, args);
	}

}
