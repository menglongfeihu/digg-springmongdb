/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: VoteLimit.java
 * @package com.sohu.tv.digg.vote.dao
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午4:04:54
 * @version V1.0
 *
 */
package com.sohu.tv.digg.vote.dao;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.sohu.tv.digg.common.MongodbBaseDao;
import com.sohu.tv.digg.vote.model.VoteLimit;

/**
 * @className: VoteLimit
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午4:04:54
 * @version V1.0
 *
 */

@Repository(value = "voteLimitDao")
public class VoteLimitDao extends MongodbBaseDao<VoteLimit> {

    public void remove(Integer platform) {
        Query query = new Query(Criteria.where("platform").is(platform));
        super.remove(query);
    }

    public VoteLimit update(VoteLimit voteLimit) {
        Query query = new Query(Criteria.where("platform").is(voteLimit.getPlatform()));
        Update update = new Update();
        update.set("theme", voteLimit.getTheme())
        .set("count", voteLimit.getCount())
        .set("needLogin", voteLimit.getNeedLogin())
        .set("description", voteLimit.getDescription())
        .set("votingEnabledStartTime", voteLimit.getVotingEnabledStartTime())
        .set("votingEnabledEndTime", voteLimit.getVotingEnabledEndTime());

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);
        VoteLimit voteLimit2 = super.findAndModify(query, update, options);

        return voteLimit2;
    }

    public VoteLimit getVoteLimitByPlatform(Integer platform) {
        Query query = new Query(Criteria.where("platform").is(platform));
        return super.findOne(query);
    }



}
