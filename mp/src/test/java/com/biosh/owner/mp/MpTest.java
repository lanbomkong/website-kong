package com.biosh.owner.mp;

import com.biosh.owner.mp.dao.BizUserMapper;
import com.biosh.owner.mp.model.BizUser;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MpStarter.class)
public class MpTest {

  @Autowired
  private BizUserMapper userMapper;


  @Autowired
  private RedisTemplate redisTemplate;

  @Test
  public void testGeo() {
//	Point point = new Point(112.23, 29);
//	redisTemplate.opsForGeo().add("vehicle", point, 10001);

	GeoOperations geoOperations = redisTemplate.opsForGeo();
    Circle circle = new Circle(112.23, 29,1000);
//    geoOperations.radius()
    RedisGeoCommands.GeoRadiusCommandArgs geoRadiusCommandArgs = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs();
   geoRadiusCommandArgs.includeCoordinates().includeDistance().limit(3L);

    GeoResults vehicle = geoOperations.radius("vehicle", circle, geoRadiusCommandArgs);
    List<GeoResult> content = vehicle.getContent();
    System.out.println(content.size());
    for (int i = 0; i < content.size(); i++) {
      RedisGeoCommands.GeoLocation location =(RedisGeoCommands.GeoLocation) content.get(i).getContent();
      System.out.println(location.getName());
      System.out.println(location.getPoint().getX());
      System.out.println(location.getPoint().getY());
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
    user.setDeleted((byte)0);
    int row = userMapper.insert(user);
    System.out.println(row);
  }

}
