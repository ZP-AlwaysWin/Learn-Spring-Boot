package com.alwayswin.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//告诉SpringBoot我是一个入口类，运行我就能启动SB
//会自动扫描可以被注入的类，并初始化
//@Repository / @Service / @Controller / @Component / @Entity
@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        //启动SpringBoot，并初始化相关的组件
        SpringApplication.run(MySpringBootApplication.class);
    }
}
