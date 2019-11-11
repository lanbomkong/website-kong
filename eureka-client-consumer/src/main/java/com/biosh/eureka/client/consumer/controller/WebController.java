package com.biosh.eureka.client.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description
 * @date 2019/10/29
 */
@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consume/hello")
    public Object sayHello() {

        System.out.println("http://eureka-client/hello");

        return restTemplate.getForObject("http://eureka-client/hello", String.class);
    }
}
