package com.biosh.owner.common.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/7/1
 */
@Component
public class LoginQueueConsumer extends MessageConsumer {

    Logger logger = LoggerFactory.getLogger(LoginQueueConsumer.class);

    @RabbitListener(queues = "loginMessage")
    void delBody(String message) {
        logger.info("成功消费消息：" + message);
    }
}
