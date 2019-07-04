package com.biosh.owner.common.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;

/**
 * @description
 * @date 2019/7/1
 */
public abstract class MessageConsumer {

    Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @RabbitHandler
    public void process(String message) {
        logger.info("收到消息-->：" + message);
        delBody(message);
    }

    abstract void delBody(String message);

}
