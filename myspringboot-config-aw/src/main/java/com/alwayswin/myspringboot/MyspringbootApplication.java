package com.alwayswin.myspringboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//在入口类启动时加载config.properties
@PropertySource("classpath:config.properties")
public class MyspringbootApplication {

	public static void main(String[] args) {

//		SpringApplication.run(MyspringbootApplication.class, args);
		SpringApplication app = new SpringApplication(MyspringbootApplication.class);
		//关闭Banner
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
