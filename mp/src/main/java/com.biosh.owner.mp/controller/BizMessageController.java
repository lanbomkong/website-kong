package com.biosh.owner.mp.controller;


import com.biosh.owner.mp.impl.BizMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author longlingbiao
 * @since 2019-07-16
 */
@RestController
@RequestMapping("/message/biz-message")
public class BizMessageController {

    @Autowired
    private BizMessageServiceImpl messageService;

    @RequestMapping("/get")
    public String getMessages() {
        try {
            messageService.insert();
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "ok";
    }
}

