package com.biosh.owner.common.filter;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/6/24
 */
@Component
public class FilterManager {

    private FilterChain filterChain;

    public void setFilterChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }

    public void execute(HttpServletRequest request) {

    }


}
