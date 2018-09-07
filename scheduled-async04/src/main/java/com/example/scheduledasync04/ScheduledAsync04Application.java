package com.example.scheduledasync04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;

@SpringBootApplication
public class ScheduledAsync04Application {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledAsync04Application.class, args);
	}

	@EnableAsync
	@Configuration
	class TaskPoolConfig {

		@Bean("taskExecutor")
		public Executor taskExecutor() {
			ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
			executor.setPoolSize(20);
			executor.setThreadNamePrefix("taskExecutor-");
			return executor;
		}
	}
}
