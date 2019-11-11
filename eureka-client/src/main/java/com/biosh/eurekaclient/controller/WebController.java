package com.biosh.eurekaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2019/10/29
 */
@RestController
public class WebController {

    @GetMapping("/hello")
    public Object sayHello() {
        return "hello";
    }

}
