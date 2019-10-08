package com.biosh.owner.web.controller;

import com.biosh.owner.common.constants.ApplicationRetStubInfo;
import com.biosh.owner.common.constants.RetStubDetailInfo;
import com.biosh.owner.common.message.MessageProducer;
import com.biosh.owner.db.mapper.BizMessageMapper;
import com.biosh.owner.db.model.BizMessage;
import com.biosh.owner.web.dto.input.UserForm;
import com.biosh.owner.web.service.AccountService;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private BizMessageMapper messageMapper;
    @Value("${rabbitmq.exchange.login}")
    private String exchangeName;

    @Value("${rabbitmq.queue.login}")
    private String queueName;

    @PostMapping("/login")
    public String userLogin (@Valid @RequestBody UserForm userForm) {
        BizMessage message = new BizMessage();
        message.setContent(String.format("username：%s, password：%s", userForm.getUsername(), userForm.getPassword()));
        message.setCreated(new Date());

        messageMapper.insertSelective(message);

        producer.sendPub("login", message);
        return accountService.userLogin(userForm);
    }

    @GetMapping("/async")
    public Object aysncMethod() {
        accountService.asyncMethod();
        System.out.println("now time!!!");
//        return "this is cool!!!";
        throw new ApplicationRetStubInfo(RetStubDetailInfo.NEED_LOGIN);
    }


}
