package com.biosh.owner.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.biosh.owner.mp.dao.BizMessageMapper;
import com.biosh.owner.mp.dao.BizUserMapper;
import com.biosh.owner.mp.model.BizMessage;
import com.biosh.owner.mp.model.BizUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MpStarter.class)
public class MpTest {

    @Autowired
    private BizUserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private BizMessageMapper messageMapper;

    @Test
    public void testXML() {
        QueryWrapper<BizMessage> messageQueryWrapper = new QueryWrapper<>();
        messageQueryWrapper.eq("deleted", 0);
        List<BizMessage> messages = messageMapper.selectList(messageQueryWrapper);
        messages.forEach(msg -> System.out.println(msg.getContent()));
        System.out.println(messageMapper.getCount());
    }

    @Test
    public void geoTest() {
        GeoOperations geoOperations = redisTemplate.opsForGeo();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        System.out
//            .println(geoOperations.add("vehicle:position:online", new Point(112.23, 29.11), 10001));
//        System.out.println(geoOperations.position("vehicle:position:online", 10001).get(0));
        List list = new ArrayList();
        list.add("name1");
        list.add("name2");
        list.add("name3");

        System.out.println(redisTemplate.opsForValue().multiGet(list));

    }

    @Test
    public void testGeo() {
//	Point point = new Point(112.23, 29);
//	redisTemplate.opsForGeo().add("vehicle", point, 10001);

        GeoOperations geoOperations = redisTemplate.opsForGeo();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        Distance distance = new Distance(1000, Metrics.KILOMETERS);
        Circle circle = new Circle(new Point(112.23,23), distance);
//    geoOperations.radius()
        RedisGeoCommands.GeoRadiusCommandArgs geoRadiusCommandArgs = RedisGeoCommands.GeoRadiusCommandArgs
            .newGeoRadiusArgs();
        geoRadiusCommandArgs.limit(3L);

        GeoResults vehicle = geoOperations.radius("vehicelgeo", circle, geoRadiusCommandArgs);
        System.out.println(vehicle);
        List<GeoResult> content = vehicle.getContent();
        System.out.println(content);
//        System.out.println(content.size());
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i));
            RedisGeoCommands.GeoLocation location = (RedisGeoCommands.GeoLocation) content.get(i)
                .getContent();
            System.out.println(location.getName());
//            System.out.println(location.getPoint().getX());
//            System.out.println(location.getPoint().getY());
//      System.out.println(content.get(i).getContent());
        }

    }


    @Test
    public void select() {
        BizUser user = userMapper.selectById(1001);
        System.out.println(user);
    }

    @Test
    public void insert() {
        BizUser user = new BizUser();
//    user.setId(1001);
        user.setUsername("zhangsan");
        user.setPassword("123");
        user.setAddress("jx");
        user.setEmail("zs@qq.com");
        user.setCreateAt(new Date());
        user.setDeleted((byte) 0);
        int row = userMapper.insert(user);
        System.out.println(row);
    }

}
