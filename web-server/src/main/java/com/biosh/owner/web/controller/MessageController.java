package com.biosh.owner.web.controller;

import com.biosh.owner.common.message.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Admin
 * @description
 * @date 2020/5/17
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/send")
    public void sendMessage(String queueName) throws InterruptedException {


        messageProducer.send(queueName, "mq dead line test");

    }
}
