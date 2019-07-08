package com.biosh.owner.common.message;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @date 2019/7/8
 */
@Configuration
public class RabbitmqConfigure {

    @Value("${rabbitmq.exchange.login}")
   private String exchangeName;

    @Bean
    public Queue autoDeleteQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public FanoutExchange createExchange() {
        return new FanoutExchange(exchangeName);
    }

    @Bean
    public Binding binding0(FanoutExchange exchange, Queue autoDeleteQueue) {
        return BindingBuilder.bind(autoDeleteQueue).to(exchange);
    }

    @Bean
    public Binding binding1(FanoutExchange exchange, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(exchange);
    }

}
