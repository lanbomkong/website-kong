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
@Component("stringTemplate")
public class RedisUtil implements RedisBase {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public void set(String key, Object value) {
        template.opsForValue().set(key, JSON.toJSONString(value));
    }

    @Override
    public void set(String key, Object value, Long expired) {
        template.opsForValue().set(key, JSON.toJSONString(value), expired, TimeUnit.SECONDS);
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        return JSON.parseObject(template.opsForValue().get(key), clazz);
    }


    public boolean del(String key) {
        return template.delete(key);
    }
}
