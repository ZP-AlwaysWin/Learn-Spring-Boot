package com.example.demo.controller;

import com.example.demo.service.VideoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    @Qualifier("videoC")
    private VideoService videoService;

    @RequestMapping("/test")
    public String testindex(){
        return videoService.getVideoName();
    }
}
