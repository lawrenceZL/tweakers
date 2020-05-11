package com.data.tweakers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.data.service", "com.data.controller", "com.data.dao"})
public class TweakersApplication {

    public static void main(String[] args) {
        SpringApplication.run(TweakersApplication.class, args);
    }

}
