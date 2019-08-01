package com.netease.chaoge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.netease.chaoge.mapper")
@SpringBootApplication
public class ChaogeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChaogeApplication.class, args);
    }

}
