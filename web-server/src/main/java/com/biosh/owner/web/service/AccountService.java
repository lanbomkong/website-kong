package com.biosh.owner.web.service;

import com.biosh.owner.common.constants.RedisConstant;
import com.biosh.owner.common.util.RedisBase;
import com.biosh.owner.common.util.StringUtil;
import com.biosh.owner.db.mapper.BizUserMapper;
import com.biosh.owner.db.model.BizUser;
import com.biosh.owner.db.util.Condition;
import com.biosh.owner.web.dto.input.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description
 * @date 2019/6/20
 */
@Service
public class AccountService {

    @Autowired
    private BizUserMapper bizUserMapper;

    @Autowired()
    @Qualifier("stringTemplate")
    private RedisBase redisUtil;

    @Async
    public void asyncMethod() {
        System.out.println("before sleep:"+ new Date().toString());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("after sleep:" + new Date().toString());
        }
    }

    public String userLogin(UserForm userForm) {
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition("username", userForm.getUsername()));
        conditions.add(new Condition("password", userForm.getPassword()));
        List<BizUser> users = bizUserMapper.getByConditionList(conditions);
        if (users.size() > 0) {

            Integer id = users.get(0).getId();
            // 查询缓存, 删除已有token
            String token = redisUtil.get(String.format(RedisConstant.ACCOUNT_LOGIN_TOKEN, id), String.class);
            if (!StringUtils.isEmpty(token)) {
                redisUtil.del(String.format(RedisConstant.ACCOUNT_LOGIN_USERID, token));
            }

            // 生成token
            token = StringUtil.generateToken();
            // 将token添加至缓存
            redisUtil.set(String.format(RedisConstant.ACCOUNT_LOGIN_TOKEN, id), token);
            redisUtil.set(String.format(RedisConstant.ACCOUNT_LOGIN_USERID, token), id);
            return token;
        }
        return "user not exit or password error";
    }
}
