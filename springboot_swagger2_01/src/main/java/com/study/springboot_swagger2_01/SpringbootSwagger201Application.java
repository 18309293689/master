package com.study.springboot_swagger2_01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.study.springboot_swagger2_01.mapper")
@EnableScheduling
@EnableAsync
public class SpringbootSwagger201Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwagger201Application.class, args);
    }

}
