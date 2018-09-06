package com.example.scheduledasync02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

//为了让@Async注解能够生效，还需要在Spring Boot的主程序中配置@EnableAsync

@SpringBootApplication
@EnableAsync
public class ScheduledAsync02Application {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledAsync02Application.class, args);
	}
}
