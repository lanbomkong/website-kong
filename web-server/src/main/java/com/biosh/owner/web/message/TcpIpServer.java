package com.biosh.owner.web.message;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
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
 * @author konglingbiao
 * @description
 * @date 2020/3/23
 */
@Component
public class TcpIpServer {


    @RabbitListener(bindings = @QueueBinding(value = @Queue("tcp/ip"), exchange = @Exchange(value = "tcp" +
            "/ip", type = "fanout")))
    public void messageListener(@Payload JSONObject message, Channel channel,
                                @Headers Map<String, Object> headers) throws IOException {

        Integer seq = message.getInteger("seq");
        System.out.println(seq);
        channel.basicAck((long) headers.get(AmqpHeaders.DELIVERY_TAG), false);
    }
}
