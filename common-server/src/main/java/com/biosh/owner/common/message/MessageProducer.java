package com.biosh.owner.common.message;

import com.biosh.owner.db.mapper.BizMessageMapper;
import com.biosh.owner.db.model.BizMessage;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/7/1
 */
@Component
@Slf4j
public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BizMessageMapper messageMapper;

    private ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {

        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            if (ack) {
                BizMessage message = new BizMessage();
                message.setId(Integer.valueOf(correlationData.getId()));
                message.setStatus((byte)1);
                message.setUpdated(new Date());
                messageMapper.updateByPrimaryKeySelective(message);
                log.info("consume success?");
            } else {
                log.error(cause);
            }
        }
    };

    public void send(String queueName, Object message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }


    public void sendPub(String exchange, BizMessage message) {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        CorrelationData correlationData = new CorrelationData(message.getId().toString());
        rabbitTemplate.convertAndSend("login", "", message, correlationData);
    }

}
