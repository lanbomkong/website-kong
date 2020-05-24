package com.biosh.owner.common.message;

import com.biosh.owner.db.model.BizMessage;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @description
 * @date 2019/7/8
 * @author konglingbiao
 */
@Slf4j
@Component
public class LoginSubConsumer {

    @RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "login-queue"),
        exchange = @Exchange(name = "login-exchange", type = "fanout"))
    )
    public void messageConsumer(@Payload BizMessage message, Channel channel, @Headers Map<String, Object> headers)
        throws IOException {

        log.info("queue0 consume message" + message.getContent());
        channel.basicAck((long) headers.get(AmqpHeaders.DELIVERY_TAG), false);
    }

}
