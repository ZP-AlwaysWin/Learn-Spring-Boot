package com.example.demo.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service @Component @Configuration 注入方式相同
@Configuration
public class VideoServiceImplA implements VideoService {

    @Override
    public String getVideoName() {
        return "三生三世十里桃花";
    }

}

