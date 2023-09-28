package com.whm.wonderworld;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.whm.wonderworld.mapper")
public class WonderWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(WonderWorldApplication.class, args);
    }

}
