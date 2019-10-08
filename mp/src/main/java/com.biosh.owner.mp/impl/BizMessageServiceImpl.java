package com.biosh.owner.mp.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biosh.owner.mp.model.BizMessage;
import com.biosh.owner.mp.dao.BizMessageMapper;
import com.biosh.owner.mp.service.IBizMessageService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author longlingbiao
 * @since 2019-07-16
 */
@Service
public class BizMessageServiceImpl extends ServiceImpl<BizMessageMapper, BizMessage> implements IBizMessageService {

    @Autowired
    private BizMessageMapper messageMapper;

    public void insert() {
        BizMessage message= new BizMessage();
        message.setContent("is a message");
        message.setCreated(LocalDateTime.now());
        messageMapper.insert(message);
    }
}
