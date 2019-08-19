package com.biosh.owner.mp.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.biosh.owner.mp.MpStarter;
import com.biosh.owner.mp.dao.BizMessageMapper;
import com.biosh.owner.mp.dao.BizUserMapper;
import com.biosh.owner.mp.model.BizMessage;
import com.biosh.owner.mp.model.BizUser;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description
 * @date 2019/7/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MpStarter.class)
public class MpTest {

    public static void main(String[] args) {
        List<Integer> firstList = new ArrayList<>();
        firstList.add(12);
        firstList.add(13);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(14);
        secondList.add(111);
        firstList.addAll(firstList.size(),secondList);

        for (int i = 0; i < firstList.size(); i++) {
            System.out.println(firstList.get(i));
        }
    }


    @Autowired
    private BizUserMapper userMapper;

    @Autowired
    private BizMessageMapper messageMapper;

    @Test
    public void insertMessage(){
//        messageMapper.
        BizMessage message= new BizMessage();
        message.setContent("is a message");
        message.setCreated(LocalDateTime.now());
        messageMapper.insert(message);
    }
    @Test
    public void selectUser() {
        List<BizUser> users = userMapper.selectBatchIds(Arrays.asList(1001, 1002));
        System.out.println("查询用户信息：");
        users.forEach(user -> {
            System.out.println(user);
        });

        QueryWrapper<BizUser> wrapper = new QueryWrapper<>();
    }

    @Test
    public void selectByWrapper() {
        QueryWrapper<BizUser> wrapper = new QueryWrapper();
        wrapper.eq("deleted", 1);
        List<Object> users = userMapper.selectObjs(wrapper);
        System.out.println(users.size());
    }


    @Test
    public void insert() {
        BizUser user = new BizUser();
        user.setAddress("sz");
        user.setUsername("klb");
        user.setPassword("1996");
        user.setCreateAt(new Date());
        user.setEmail("klb@qq.com");

        userMapper.insert(user);
    }

    @Test
    public void update() {
        BizUser user = new BizUser();
        user.setId(1002);
        user.setUsername("lanbomkong");
        userMapper.updateById(user);
    }

    @Test
    public void delete() {
        int row = userMapper.deleteById(1003);
        System.out.println(row);
    }
}
