package com.example.demo.service;


import org.springframework.stereotype.Service;

@Service("videoC")
public class VideoServiceImplC implements VideoService{

    @Override
    public String getVideoName() {
        return "延禧攻略";
    }
}



