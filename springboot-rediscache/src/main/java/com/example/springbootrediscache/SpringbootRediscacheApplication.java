package com.example.springbootrediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootRediscacheApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootRediscacheApplication.class, args);
    }
}
