/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: VoteLimitService.java
 * @package com.sohu.tv.digg.vote.service
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-23 上午9:31:55
 * @version V1.0
 *
 */
package com.sohu.tv.digg.vote.service;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sohu.tv.digg.vote.dao.VoteLimitDao;
import com.sohu.tv.digg.vote.model.VoteLimit;

/**
 * @className: VoteLimitService
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-23 上午9:31:55
 * @version V1.0
 *
 */
@Service(value = "voteLimitService")
public class VoteLimitService {

    private static final Logger LOGGER = Logger.getLogger(VoteLimitService.class);

    @Resource
    VoteLimitDao voteLimitDao;

    public void delete(Integer platform) {
        this.voteLimitDao.remove(platform);
     }

    public VoteLimit save(VoteLimit voteLimit) {
        LOGGER.info("save votelimt:" + voteLimit.toString());
        return this.voteLimitDao.save(voteLimit);
    }

    public VoteLimit getVoteLimitByPlatform(Integer platform) {

        return this.voteLimitDao.getVoteLimitByPlatform(platform);
    }

    public VoteLimit update(VoteLimit voteLimit) {
        return this.voteLimitDao.update(voteLimit);
    }


}
