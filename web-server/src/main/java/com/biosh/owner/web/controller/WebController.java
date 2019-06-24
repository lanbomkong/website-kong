package com.biosh.owner.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description
 * @date 2019/6/20
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @RequestMapping("/{page}")
    public Object showPage (@PathVariable("page") String page) {
        return page;
    }

}
