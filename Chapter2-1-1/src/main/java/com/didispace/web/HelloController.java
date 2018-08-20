package com.didispace.web;

import com.didispace.service.BlogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@RestController
public class HelloController {
    //@Autowired
    @Resource
    BlogProperties blogProperties;


    @RequestMapping("/config")
    public String config(){
        return blogProperties.getTest1().toString()+blogProperties.getTest2().toString();
    }

    @RequestMapping("/hello")
    public String index() {
        return blogProperties.getBignumber().toString();
    }



}