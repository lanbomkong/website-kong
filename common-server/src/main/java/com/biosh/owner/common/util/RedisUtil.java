package com.biosh.owner.common.util;

import com.alibaba.fastjson.JSON;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/6/20
 */
@Component
public class RedisUtil{

    @Autowired
    private StringRedisTemplate template;

    public void set(String key, Object value){
        template.opsForValue().set(key, JSON.toJSONString(value));
    }

    public void set(String key, Object value, Long expireTime){
        template.opsForValue().set(key, JSON.toJSONString(value), expireTime, TimeUnit.SECONDS);
    }
}
