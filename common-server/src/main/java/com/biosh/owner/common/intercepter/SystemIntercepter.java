package com.biosh.owner.common.intercepter;

import com.biosh.owner.common.filter.FilterManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description
 * @date 2019/6/20
 */
@Component
public class SystemIntercepter implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(SystemIntercepter.class);

    private Long startTime;
    private Long endTime;

    @Autowired
    private FilterManager filterManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {
        startTime = System.currentTimeMillis();

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        endTime = System.currentTimeMillis();
        logger.info("invoke：" + request.getRequestURI() + "  cost time：" + (endTime - startTime) + "ms");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
        Object handler, Exception ex) throws Exception {
    }
}
