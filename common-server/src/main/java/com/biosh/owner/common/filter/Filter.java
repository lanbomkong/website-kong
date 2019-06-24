package com.biosh.owner.common.filter;

import javax.servlet.http.HttpServletRequest;

/**
 * @description
 * @date 2019/6/24
 */
public interface Filter {

     void execute(HttpServletRequest request);

}
