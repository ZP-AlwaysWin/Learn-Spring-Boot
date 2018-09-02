package com.example.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class VideoServiceImplB implements VideoService {

    @Override
    public String getVideoName() {
        return "人民的名义";
    }

}