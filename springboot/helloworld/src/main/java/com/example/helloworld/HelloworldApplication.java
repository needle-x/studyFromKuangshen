package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//本身就是Spring的一个组件
//程序的主入口
@SpringBootApplication
public class HelloworldApplication {

    public static void main(String[] args) {
        //SpringApplication
        SpringApplication.run(HelloworldApplication.class, args);
    }

}
