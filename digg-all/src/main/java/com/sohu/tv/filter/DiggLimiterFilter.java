/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: DiggLimiterFilter.java
 * @package com.sohu.tv.filter
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-23 上午10:36:45
 * @version V1.0
 *
 */
package com.sohu.tv.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSONObject;

import com.sohu.configs.utils.HotConfigUtils;

/**
 * @className: DiggLimiterFilter
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-23 上午10:36:45
 * @version V1.0
 *
 */
public class DiggLimiterFilter implements Filter {

   private ServletContext context;

    private ApplicationContext ctx;

    private HotConfigUtils hotConfigUtils;

    @Override
    public void destroy() {
    }

    ApplicationContext getContext(ServletRequest request) {
        HttpServletRequest _request = (HttpServletRequest) request;
        if (context == null) {
            context = _request.getSession().getServletContext();
        }
        if (ctx == null) {
            ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        }
        return ctx;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        ctx = getContext(request);

        if (hotConfigUtils == null) {
            hotConfigUtils = (HotConfigUtils) ctx.getBean("hotConfigUtils");
        }

        if (hotConfigUtils != null) {
            // 配置开关是否开启
            if (hotConfigUtils.trueValue("switcher")) {
                String vids = hotConfigUtils.getValue("vid");
                // 从请求中获取当前顶踩的vid
                String vid = request.getParameter("vid");
                // 如果包含了当前的 vid,意思就是当前视频不需要踩，直接返回
                if (vids.contains(vid)) {

                    PrintWriter pw = response.getWriter();
                    JSONObject o = new JSONObject();
                    o.put("status", 200);
                    o.put("statusText", "diggDown");
                    pw.write(o.toString());
                } else {
                    chain.doFilter(request, response);
                }
            } else {
                chain.doFilter(request, response);
            }

        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}
