package com.biosh.owner.common.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/7/8
 */
@Slf4j
@Component
public class LoginSubConsumer {

    @RabbitListener(queues = "#{autoDeleteQueue.name}")
    public void reciver0(String message) {
        log.info("queue0 consume message" + message);
    }

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void reciver1(String message) {
        log.info("queue1 consume message" + message);
    }
}
