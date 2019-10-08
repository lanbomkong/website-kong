package com.biosh.owner.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description
 * @date 2019/8/2
 */
@SpringBootApplication
//@EnableWebSecurity
public class ServerStarter {

    public static void main(String[] args) {
        SpringApplication.run(ServerStarter.class, args);
    }
}
