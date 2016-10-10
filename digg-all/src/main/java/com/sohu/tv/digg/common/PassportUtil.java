package com.sohu.tv.digg.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * Created by huangbin on 16/1/11.
 */
public class PassportUtil {
    private static Logger logger = Logger.getLogger(PassportUtil.class);

    // header提取passport
    public static String getLoginPassport(HttpServletRequest request) {
        String passport = request.getHeader("X-SohuPassport-UserId");
        if (StringUtils.isBlank(passport) || passport.indexOf("@focus.cn") <= 0) {
            return passport;
        }
        try {
            passport = new String(passport.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            logger.error("get passport failed,the reason : " + e.getMessage());
        }

        return passport;
    }

}
