package com.example.demo.controller;

import com.example.demo.service.VideoService;
import com.example.demo.service.VideoServiceImplA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HomeController {

    //@Autowired
    @Resource
    private VideoService videoService;

    @RequestMapping("/video")
    public String videoName(){
        return videoService.getVideoName();
    }

}

