package com.biosh.owner.mp;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description
 * @date 2019/7/16
 */
@SpringBootApplication
@MapperScan("com.biosh.owner.mp.dao")
@EnableDubbo
public class MpStarter {

    public static void main(String[] args) {
        SpringApplication.run(MpStarter.class, args);
    }
}
