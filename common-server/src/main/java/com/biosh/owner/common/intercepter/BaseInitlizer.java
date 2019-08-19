package com.biosh.owner.common.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description
 * @date 2019/6/20
 */
@Configuration
public class BaseInitlizer implements WebMvcConfigurer {

    @Autowired
    private SystemInterceptor systemInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.systemInterceptor).addPathPatterns("/**");
    }
}
