package com.biosh.owner.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.biosh.owner.common.filter.DubboService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author konglingbiao
 * @description
 * @date 2020/3/24
 */
@Service
@Component
public class DubboServiceImpl implements DubboService {


    @Override
    public String getString() {
        LoggerFactory.getLogger(DubboServiceImpl.class).info("is ok");
        return "hello world!";
    }


}
