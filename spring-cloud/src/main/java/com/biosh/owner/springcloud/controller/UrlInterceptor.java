package com.biosh.owner.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @description
 * @date 2019/9/8
 */
@RestController
@RequestMapping("/intercept")
public class UrlInterceptor implements HandlerInterceptor {

    @GetMapping("/getStr")
    public String getInterceptStr() {
        return "intercept success";
    }

}
