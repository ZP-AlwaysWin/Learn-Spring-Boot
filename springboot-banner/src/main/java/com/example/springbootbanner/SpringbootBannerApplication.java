package com.example.springbootbanner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBannerApplication {

	public static void main(String[] args) {
		SpringApplication sb=new SpringApplication(SpringbootBannerApplication.class);
		sb.setBannerMode(Banner.Mode.OFF);
		sb.run(args);

		//默认的写法
		//SpringApplication.run(SpringbootBannerApplication.class, args);
	}
}
