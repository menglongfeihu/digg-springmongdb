/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: VoteDao.java
 * @package com.sohu.tv.digg.vote.dao
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午6:04:33
 * @version V1.0
 *
 */
package com.sohu.tv.digg.vote.dao;

import org.springframework.stereotype.Repository;

import com.sohu.tv.digg.common.MongodbBaseDao;
import com.sohu.tv.digg.vote.model.Vote;


/**
 * @className: VoteDao
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午6:04:33
 * @version V1.0
 *
 */

@Repository(value = "voteDao")
public class VoteDao extends MongodbBaseDao<Vote> {

}
