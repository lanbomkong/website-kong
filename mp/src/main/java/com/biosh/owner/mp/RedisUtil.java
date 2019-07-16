package com.biosh.owner.mp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisUtil {

  @Autowired
  private RedisTemplate redisTemplate;

  public void geoTest() {
    Point point = new Point(12.231,12312);
    redisTemplate.opsForGeo().add("vehicle",point,"10001");

  }

}
