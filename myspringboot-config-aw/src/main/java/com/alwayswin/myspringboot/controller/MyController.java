package com.alwayswin.myspringboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class MyController {
    @Value("${app.name}")
    private String name;
    @Value("${app.page-size}")
    private Integer pageSize;
    //动态注入IOC容器中匹配的Bean
    @Resource //相同功能可使用@Autowire
    private AppConfig appConfig;

    @RequestMapping("/")
    public String index() {
        //访问index.html
        return "idx";
    }

    @RequestMapping("/out")
    @ResponseBody //ResponseBody注解可以帮我们将返回的对象JSON序列化
    public Date out(Date sdate) {
        return sdate;
    }
}
