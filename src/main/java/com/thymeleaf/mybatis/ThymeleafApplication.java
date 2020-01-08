package com.thymeleaf.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.thymeleaf.mybatis.mapper")
public class ThymeleafApplication {

    public static void main(String[] args) {
        System.out.println(123);
        SpringApplication.run(ThymeleafApplication.class, args);
    }

}
