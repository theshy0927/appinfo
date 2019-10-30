package com.t248.appinfo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@ComponentScan("com.t248.appinfo")
@MapperScan("com.t248.appinfo.mapper")
@SpringBootApplication
public class AppinfoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppinfoWebApplication.class, args);
    }

}
