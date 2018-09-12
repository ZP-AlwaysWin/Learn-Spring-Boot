package com.example.springboot2applicationstartedevent;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Springboot2ApplicationstartedeventApplication {

	private  static final Logger log = LoggerFactory.getLogger(Springboot2ApplicationstartedeventApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Springboot2ApplicationstartedeventApplication.class, args);
	}

	@Bean
	public DataLoader dataLoader() {
		return new DataLoader();
	}


	static class DataLoader implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			log.info("Loading data...");
		}
	}
}
