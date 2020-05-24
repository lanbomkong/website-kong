package com.biosh.owner.web.message;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Argument;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author Admin
 * @description
 * @date 2020/5/17
 */
@Component
public class DelayDeadQueue {

/*    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "delay-queue", arguments = {
                    @Argument(name = "x-message-ttl", value = "100", type = "java.lang.Integer"),
                    @Argument(name = "x-dead-letter-exchange", value = "delay-dead-exchange"),
                    @Argument(name = "x-dead-letter-routing-key", value = "delay-dead-queue")}),
            exchange = @Exchange(name = "delay-queue-mq")
    ))
    public void delayQueueForMq(Message message, Channel channel, @Headers Map<String, Object> headers) throws IOException {
        System.out.println("receive message: " + message.toString());

//        channel.basicAck((long) headers.get(AmqpHeaders.DELIVERY_TAG), false);
    }*/

    @RabbitListener(queuesToDeclare = {@Queue(value = "delay-queue-test",arguments = {
            @Argument(name = "x-message-ttl", value = "10000", type = "java.lang.Integer"),
            @Argument(name = "x-dead-letter-exchange", value = "delay-dead-exchange"),
            @Argument(name = "x-dead-letter-routing-key", value = "delay-dead-queue")})})
    public void delayQueueForMq(Message message, Channel channel, @Headers Map<String, Object> headers) throws IOException, InterruptedException {
        System.out.println("receive message: " + message.toString());

        Thread.sleep(500);
//        channel.basicAck((long) headers.get(AmqpHeaders.DELIVERY_TAG), false);
    }

}
