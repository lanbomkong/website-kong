package com.biosh.owner.common.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/7/1
 */
@Component
public class MessageProducer {

    @Autowired
    private AmqpTemplate template;

    public void send(String queueName, Object message) {
        template.convertAndSend(queueName, message);
    }

}
