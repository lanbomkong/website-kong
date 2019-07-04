package com.biosh.owner.common.util;

/**
 * @description
 * @date 2019/7/1
 */
public interface RedisBase {


    <T> T get(String key, Class<T> clazz);

    void set(String key, Object value);

    void set(String key, Object value, Long expired);

    boolean del(String key);
}
