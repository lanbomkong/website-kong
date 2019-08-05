package com.biosh.owner.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description
 * @date 2019/6/20
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.biosh.owner.*")
@MapperScan(basePackages = "com.biosh.owner.db.mapper")
@EnableScheduling
@EnableAsync
public class WebStarter {

    public static void main(String[] args) {
        SpringApplication.run(WebStarter.class, args);
    }

}
