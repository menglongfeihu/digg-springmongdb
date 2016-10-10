/*
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
package com.sohu.tv.filter;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.HttpRequestHandler;

import com.sohu.cache.service.Cache;

/**
 * <p>
 * 当启用该filter的时候，一个小时内同个ip超过100次请求的，直接返回，不像后端controller发出请求
 * </p>
 * 
 * @author Tony Wei
 * @version 1.0
 * @Date Jul 17, 2014
 */
public class IpFilter implements Filter {

    private ConcurrentHashMap< String, Long> ipMap=new ConcurrentHashMap<String, Long>();
    private final long n = 100;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest _request = (HttpServletRequest) request;
        String realIp = _request.getHeader("X-Real-IP");

        if (StringUtils.isNotBlank(realIp)) {
            Object count = ipMap.get(realIp);
            if (count == null) {
                ipMap.put(realIp, 1L);
            } else {
                Long _count = (Long) count;
                if (_count > n) {
                    return;
                } else {
                    ipMap.put(realIp, _count + 1);
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}
