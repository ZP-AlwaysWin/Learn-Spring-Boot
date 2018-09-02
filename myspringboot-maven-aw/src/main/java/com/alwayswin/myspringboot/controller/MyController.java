package com.alwayswin.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping("/out") //绑定到out地址
    @ResponseBody //直接向浏览器输出
    public String out() {

        return "Hello AlwaysWin";
    }
}
