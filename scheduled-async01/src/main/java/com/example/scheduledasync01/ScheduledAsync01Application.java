package com.example.scheduledasync01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


//在Spring Boot的主类中加入@EnableScheduling注解，启用定时任务的配置
@EnableScheduling
@SpringBootApplication
public class ScheduledAsync01Application {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledAsync01Application.class, args);
	}
}
