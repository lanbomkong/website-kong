package com.biosh.owner.common.message;

import com.biosh.owner.db.mapper.BizMessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Admin
 * @description
 * @date 2019/7/1
 */
@Component
@Slf4j
public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BizMessageMapper messageMapper;

    public void send(String queueName, Object message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }

    public void sendPub(String exchange, Object message, ConfirmCallback confirmCallback,
                        CorrelationData correlationData) {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.convertAndSend(exchange, "", message, correlationData);
    }

}
