package com.biosh.owner.web.message;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Admin
 * @description
 * @date 2020/5/17
 */
@Component
public class DelayQueue4Mq {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "delay-dead-queue"),
            exchange = @Exchange(name = "delay-dead-exchange")
    ))
    public void delayQueueForMq(Message message) {
        System.out.println("deal dead message: " + message.toString());
    }

}
