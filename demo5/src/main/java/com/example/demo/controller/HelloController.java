package com.example.demo.controller;

import com.example.demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    @Qualifier("videoServiceImplA")
    private VideoService videoService;

    @RequestMapping("/hello")
    @ResponseBody
    public String helloName() {
        return videoService.getVideoName();
    }
}




