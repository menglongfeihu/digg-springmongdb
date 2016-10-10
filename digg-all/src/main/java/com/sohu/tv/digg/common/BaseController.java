/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: BaseController.java
 * @package com.sohu.tv.digg.common
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-23 上午10:14:44
 * @version V1.0
 *
 */
package com.sohu.tv.digg.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sohu.blog.util.StringUtil;

/**
 * @className: BaseController
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-23 上午10:14:44
 * @version V1.0
 *
 */
public class BaseController {
   public static final String PASSPORT_HEADER = "X-SohuPassport-UserId";

   public static final String PASSPORT_UID_HEADER = "X-SohuPassport-UId";
   private static Logger logger = Logger.getLogger(BaseController.class);

   /**
    * 判断用户是否已经登录
    *
    * @param request
    * @return
    */
   public static String getLoginPassport(HttpServletRequest request) {
       String passport = request.getHeader(PASSPORT_HEADER);
       if (StringUtil.isNotEmpty(passport)) {
           if (passport.endsWith("@focus.cn")) { // 因为搜狐焦点用户名可能为中文，所以这种情况下使用PASSPORT_UID_HEADER
               passport = request.getHeader(PASSPORT_UID_HEADER);
               if (StringUtil.isNotEmpty(passport)) {
                   passport = passport + "@focus.cn";
               }
           }
       }
       if (passport == null) { // 获取未激活的passport
           passport = request.getHeader("X-SohuPassport-untrusty");
           if (passport != null && !passport.equals("") && passport.indexOf(":") != -1) {
               passport = passport.substring(passport.lastIndexOf(":") + 1);
           }
       }
       return passport;
   }

   public static String escape(String src) {
       int i;
       char j;
       StringBuffer tmp = new StringBuffer();
       tmp.ensureCapacity(src.length() * 6);

       for (i = 0; i < src.length(); i++) {

           j = src.charAt(i);

           if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
               tmp.append(j);
           else if (j == 95) {
               tmp.append(j);
           } else if (j < 256) {
               tmp.append("%");
               if (j < 16)
                   tmp.append("0");
               tmp.append(Integer.toString(j, 16));
           } else {
               tmp.append("%u");
               tmp.append(Integer.toString(j, 16));
           }
       }
       return filterHtml(tmp.toString());
   }
   // 特殊字符过滤
   private static String filterHtml(String body) {
       if (body == null) {
           return "";
       }
       body = body.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;")
               .replaceAll("'", "&quot;");
       return body;
   }

   public static void removeJessionid(HttpServletRequest request, HttpServletResponse response) {
       javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("JSESSIONID", "");
       cookie.setMaxAge(0);
       response.setContentType("text/html");
       response.addCookie(cookie);
   }

   public void printJson(HttpServletRequest request, HttpServletResponse response, String callback, String result,String encode) {
       try {
           if(StringUtil.isEmpty(encode)){
               encode="utf-8";
           }
           response.setContentType("text/html;charset="+encode);
           response.setHeader("Pragma", "No-cache");
           response.setHeader("Cache-Control", "no-cache");
           response.setDateHeader("Expires", 0);
           response.setCharacterEncoding(encode);
           response.setContentType("application/json;charset="+encode);
           StringBuilder sb = new StringBuilder();
           if (StringUtil.isEmpty(callback)) {
               sb.append(result).toString();
           } else {
               sb.append(filterHtml(callback)).append("(").append(result).append(");").toString();
           }

           byte[] data = sb.toString().getBytes(encode);
           response.setContentLength(data.length);
           response.getOutputStream().write(data, 0, data.length);
       } catch (UnsupportedEncodingException e) {
           logger.error("UnsupportedEncodingException!", e);
       }catch (Exception e) {
           logger.error("print result error!", e);
       }

   }
   public void printJson(HttpServletRequest request, HttpServletResponse response, String str) {
       try {
           response.setContentType("text/html;charset=utf-8");
           response.setHeader("Pragma", "No-cache");
           response.setHeader("Cache-Control", "no-cache");
           response.setDateHeader("Expires", 0);

           StringBuilder result = new StringBuilder(str);
           String callback = request.getParameter("callback");
           if (callback != null && callback.trim() != "") {
               result.insert(0, '(');
               result.insert(0, callback);
               result.append(")");
           }

           byte[] data = result.toString().getBytes("utf-8");
           response.setContentLength(data.length);
           response.getOutputStream().write(data, 0, data.length);
       } catch (IOException e) {
           logger.error("print result error!", e);
       }
   }

}
