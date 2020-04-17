package com.biosh.owner.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.biosh.owner.common.filter.DubboService;
import com.biosh.owner.common.message.MessageProducer;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author konglingbiao
 * @description 测试tcp/ip 三次握手过程： 客户端
 * @date 2020/3/23
 */
@RestController
public class TcpIpController {

    @Autowired
    private MessageProducer messageProducer;

    @Reference
    private DubboService dubboService;

    @RequestMapping("/dubob")
    public String getString() {

        if (dubboService != null) {

            return dubboService.getString();
        } else {
            return "service can not found!";
        }
    }


    private AtomicInteger seq = new AtomicInteger(2);

    private RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {

        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            if (ack) {
                String id = correlationData.getId();

                System.out.println(" 第三次握手");
            } else {
                System.err.println(cause);
            }
        }
    };

    @RequestMapping("/first")
    public void firstSend() {
        System.out.println("send request to server");

        JSONObject message = new JSONObject();
        message.put("seq", seq);
        message.put("SYN", 1);
        CorrelationData correlationData = new CorrelationData(message.getString("seq"));
        messageProducer.sendPub("tcp/ip", message, confirmCallback, correlationData);

    }

}
