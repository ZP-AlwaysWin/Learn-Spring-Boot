package com.example.springbootehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //Spring Boot主类中增加@EnableCaching注解开启缓存功能
public class SpringbootEhcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEhcacheApplication.class, args);
	}
}
