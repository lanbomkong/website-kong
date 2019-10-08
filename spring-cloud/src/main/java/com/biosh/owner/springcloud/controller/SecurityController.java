package com.biosh.owner.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2019/9/8
 */
@RestController
@RequestMapping("/security")
public class SecurityController {

    @GetMapping("/getStr")
    public String getSecurityStr() {
        return "intercepter success";
    }
}
