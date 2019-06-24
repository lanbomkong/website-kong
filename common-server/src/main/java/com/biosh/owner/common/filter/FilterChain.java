package com.biosh.owner.common.filter;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 * @description
 * @date 2019/6/24
 */
public class FilterChain {

    List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void execute(HttpServletRequest request) {
        for (Filter filter: filters) {

        }
    }
}
