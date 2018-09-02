package com.didispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        //SpringApplication.run(Application.class, args);
        SpringApplication sb = new SpringApplication(Application.class);
        sb.run(args);

    }

}
