/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: VotingDao.java
 * @package com.sohu.tv.digg.vote.dao
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午6:53:36
 * @version V1.0
 *
 */
package com.sohu.tv.digg.vote.dao;

import org.springframework.stereotype.Repository;

import com.sohu.tv.digg.common.MongodbBaseDao;
import com.sohu.tv.digg.vote.model.Voting;

/**
 * @className: VotingDao
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午6:53:36
 * @version V1.0
 *
 */
@Repository(value = "votingDao")
public class VotingDao extends MongodbBaseDao<Voting>{

    @Override
    public Voting save(Voting entity) {
        Long votingId = this.getClassId("voting");
        entity.setId(votingId);
        return super.save(entity);
    }

}
