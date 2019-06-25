package com.biosh.owner.common.filter;

import javax.servlet.http.HttpServletRequest;

/**
 * @description
 * @date 2019/6/24
 */
public class AuthFilter implements Filter
{

    @Override
    public void execute(HttpServletRequest request) {
        System.out.println("登录验证");
    }
}
