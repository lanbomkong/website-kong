package com.biosh.owner.web.controller;

import com.biosh.owner.common.message.MessageProducer;
import com.biosh.owner.web.dto.input.UserForm;
import com.biosh.owner.web.service.AccountService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2019/6/20
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private MessageProducer producer;

    @Value("${rabbitmq.exchange.login}")
    private String exchangeName;

    @Value("${rabbitmq.queue.login}")
    private String queueName;

    @PostMapping("/login")
    public String userLogin (@Valid @RequestBody UserForm userForm) {
        producer.send(queueName,"登录用户："+userForm.getUsername());
        producer.sendPub(exchangeName, userForm.getUsername());
        return accountService.userLogin(userForm);
    }

}
