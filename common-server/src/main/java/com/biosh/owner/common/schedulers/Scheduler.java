package com.biosh.owner.common.schedulers;

import com.biosh.owner.common.message.MessageProducer;
import com.biosh.owner.db.mapper.BizMessageMapper;
import com.biosh.owner.db.model.BizMessage;
import com.biosh.owner.db.util.Condition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/7/12
 */
@Slf4j
@Component
public class Scheduler {

    @Autowired
    private BizMessageMapper messageMapper;

    @Autowired
    private MessageProducer messageProducer;

    public void checkMessage() {
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition("created", "<=", "DATE_SUB(NOW(),INTERVAL 10 MINUTE)" , "true"));
        conditions.add(new Condition("status", 0));
        conditions.add(new Condition("retry_count", "<", 3));
        List<BizMessage> retryMessage = messageMapper.getByConditions(conditions);
        if (retryMessage != null) {
            retryMessage.forEach(message -> {
                log.info("消息重发, messageId: " + message.getId());
                message.setRetryCount((short) (message.getRetryCount() + 1));
                message.setUpdated(new Date());
                message.setRetryTime(new Date());
                messageMapper.updateByPrimaryKeySelective(message);
                messageProducer.sendPub("login-exchange", message);
            });
        }

    }
}
