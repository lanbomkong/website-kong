package com.biosh.owner.web.service;

import com.biosh.owner.common.constants.RedisConstant;
import com.biosh.owner.common.util.RedisBase;
import com.biosh.owner.common.util.StringUtil;
import com.biosh.owner.db.mapper.BizUserMapper;
import com.biosh.owner.db.model.BizUser;
import com.biosh.owner.db.util.Condition;
import com.biosh.owner.web.dto.input.UserForm;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
