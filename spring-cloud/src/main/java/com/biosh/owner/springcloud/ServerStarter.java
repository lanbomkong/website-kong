package com.biosh.owner.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description
 * @date 2019/8/2
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerStarter {

    public static void main(String[] args) {
        SpringApplication.run(ServerStarter.class, args);
    }
}
