package com.biosh.owner.web.message;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Admin
 * @description
 * @date 2020/5/17
 */
//@Configuration
public class QueueConfiguration {


//    @Bean(name = "delay-queue")
    public Queue queueConfig() {
        Map<String, Object> args = new HashMap<>(16);
        args.put("x-message-ttl", 1000);
        args.put("x-dead-letter-exchange", "delay-dead-exchange");
        args.put("x-dead-letter-routing-key", "delay-dead-queue");
        return QueueBuilder.durable().withArguments(args).build();
    }

}
