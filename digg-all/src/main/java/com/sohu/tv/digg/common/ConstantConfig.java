/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
package com.sohu.tv.digg.common;

public class ConstantConfig {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_LACK_PARAM = 100;
    public static final int STATUS_USER_INVALID = 102;
    public static final int STATUS_TOKEN_INVALID = 103;
    public static final int STATUS_FAIL = 104;
    public static final int STATUS_NO_PRIVILEGE = 105;
    public static final int STATUS_ERROR_PARAM = 106;
    public static final int STATUS_NO_LOGIN = 112;

    public static final String VOTELIMIT_NOT_START = "投票还未开始";
    public static final String VOTELIMIT_HAS_END = "投票已经结束";
    public static final String VOTELIMIT_NO_LIMIT = "没有投票限制";
    public static final String VOTELIMIT_HAS_LIMIT = "有投票限制";
    public static final String VOTELIMIT_NOT_EXIST = "活动不存在";
    public static final String VOTELIMIT_PASS_COUNT = "你今天已经投票了";
    public static final String VOTELIMIT_NOT_LOGIN = "未登录";

    public static final Integer EXPIRE_TIME_MIN_1 = 60; // 1 min
    public static final Integer EXPIRE_TIME_HOUR_1 = 3600; // 1 hour
    public static final Integer EXPIRE_TIME_DAY_1 = 3600 * 24; // 1 day
    public static final Integer EXPIRE_TIME_WEEK_1 = 7 * 3600 * 24; // 1 week

    public static final String VOTE_LIMIT = "votelimit_platform_%s";
}
