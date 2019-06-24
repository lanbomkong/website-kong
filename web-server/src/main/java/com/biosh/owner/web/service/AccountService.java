package com.biosh.owner.web.service;

import com.biosh.owner.common.constants.RedisConstant;
import com.biosh.owner.common.util.RedisUtil;
import com.biosh.owner.common.util.StringUtil;
import com.biosh.owner.db.mapper.BizUserMapper;
import com.biosh.owner.db.model.BizUser;
import com.biosh.owner.db.util.Condition;
import com.biosh.owner.web.dto.input.UserForm;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @date 2019/6/20
 */
@Service
public class AccountService {

    @Autowired
    private BizUserMapper bizUserMapper;

    @Autowired
    private RedisUtil template;

    public String userLogin(UserForm userForm) {
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition("username", userForm.getUsername()));
        conditions.add(new Condition("password", userForm.getPassword()));
        List<BizUser> users = bizUserMapper.getByConditionList(conditions);
        if (users.size() > 0) {

            //生成token
            String token =  StringUtil.generateToken();

            //将token添加至缓存
            Integer id = users.get(0).getId();
            template.set(String.format(RedisConstant.ACCOUNT_LOGIN_TOKEN, id), token);
            template.set(String.format(RedisConstant.ACCOUNT_LOGIN_USERID, token), id);
            return token;
        }
        return "user not exit or password error";
    }
}
