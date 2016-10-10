/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: VotingController.java
 * @package com.sohu.tv.digg.controller
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-23 上午10:02:28
 * @version V1.0
 *
 */
package com.sohu.tv.digg.controller;


import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONObject;

import com.sohu.blog.web.util.RequestUtil;
import com.sohu.tv.digg.common.BaseController;
import com.sohu.tv.digg.common.ConstantConfig;
import com.sohu.tv.digg.vote.model.VoteLimit;
import com.sohu.tv.digg.vote.service.VoteLimitService;

/**
 * @className: VotingController
 * @description: 该Controller主要用于活动专题进行投票入口
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-23 上午10:02:28
 * @version V1.0
 *
 */

@Controller
public class VotingController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(VotingController.class);

    @Resource
    VoteLimitService voteLimitService;

    @RequestMapping(value = "/voting/savevotelimit")
    public void saveVoteLimt(HttpServletRequest request, HttpServletResponse response) {
        // get params from front
        String callback = RequestUtil.getString(request, "callback", "");
        String encode = RequestUtil.getString(request, "encode", "utf-8");
        Integer platform = RequestUtil.getInt(request, "platform", 0);
        Integer count = RequestUtil.getInt(request, "count", 0);
        Integer needLogin = RequestUtil.getInt(request, "needLogin", 0);
        String theme = RequestUtil.getString(request, "theme", "");
        String description = RequestUtil.getString(request, "description", "");
        Long votingEnabledStartTime = RequestUtil.getLong(request, "votingEnabledStartTime", 0);
        Long votingEnabledEndTime = RequestUtil.getLong(request, "votingEnabledEndTime", 0);

        LOGGER.info("request params :platform = " + platform + "|count = " + count + "|needLogin = " + needLogin
                + "|theme = " + theme + "|description = "
                + description + "|votingEnabledStartTime = " + votingEnabledStartTime + "|votingEnabledEndTime = "
                + votingEnabledEndTime);

        JSONObject result = new JSONObject();
        result.put("status", ConstantConfig.STATUS_SUCCESS);
        result.put("msg", "ok");
        if (0 == platform || StringUtils.isBlank(theme)) {
            result.put("status", ConstantConfig.STATUS_LACK_PARAM);
            result.put("msg", "missing required params : platform | theme ");
            super.printJson(request, response, callback, result.toString(), encode);
            return;
        }

        VoteLimit voteLimitOri = voteLimitService.getVoteLimitByPlatform(platform);
        if (voteLimitOri != null) {
            voteLimitOri.setCount(count);
            voteLimitOri.setTheme(theme);
            voteLimitOri.setPlatform(platform);
            voteLimitOri.setNeedLogin(needLogin);
            voteLimitOri.setDescription(description);
            voteLimitOri.setCreateTime(new Timestamp(new Date().getTime()));
            voteLimitOri.setVotingEnabledStartTime(votingEnabledStartTime);
            voteLimitOri.setVotingEnabledEndTime(votingEnabledEndTime);
            VoteLimit voteLimit = voteLimitService.update(voteLimitOri);
            LOGGER.info(voteLimit);

            return;
        } else {
            VoteLimit voteLimit = new VoteLimit();
            voteLimit.setCount(count);
            voteLimit.setTheme(theme);
            voteLimit.setPlatform(platform);
            voteLimit.setNeedLogin(needLogin);
            voteLimit.setDescription(description);
            voteLimit.setCreateTime(new Timestamp(new Date().getTime()));
            voteLimit.setVotingEnabledStartTime(votingEnabledStartTime);
            voteLimit.setVotingEnabledEndTime(votingEnabledEndTime);

            LOGGER.info("新增投票平台：" + voteLimit.toString());
            voteLimitService.save(voteLimit);

        }
    }
}
