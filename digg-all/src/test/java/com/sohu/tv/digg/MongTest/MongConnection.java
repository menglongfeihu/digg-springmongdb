/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: MongConnection.java
 * @package com.sohu.tv.digg.MongTest
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午4:14:21
 * @version V1.0
 *
 */
package com.sohu.tv.digg.MongTest;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sohu.tv.digg.vote.dao.VoteLimitDao;
import com.sohu.tv.digg.vote.model.VoteLimit;
import com.sohu.tv.digg.vote.service.VoteLimitService;

/**
 * @className: MongConnection
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午4:14:21
 * @version V1.0
 *
 */
public class MongConnection {

    private static final Logger LOGGER = Logger.getLogger(MongConnection.class);

    /**
     * @description:
     * @author anzengli (anzengli@sohu-inc.com)
     * @date 2016-9-22 下午4:14:21
     * @version V1.0
     * @param args
     * @return void
     * @throws
     *
     */
    public static void main(String[] args) {
        LOGGER.info("Bootstrapping HelloMongo");

        ConfigurableApplicationContext context = null;
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        VoteLimitDao voteLimitDao = (VoteLimitDao) context.getBean("voteLimitDao");
        VoteLimit voteLimit = new VoteLimit();
        voteLimit.setCount(1);
        voteLimit.setCreateTime(new Timestamp(new Date().getTime()));
        voteLimit.setDescription("kkk");
        voteLimit.setTheme("kkk");
        voteLimit.setPlatform(24);
        voteLimit.setNeedLogin(0);
        voteLimit.setVotingEnabledEndTime(0L);
        voteLimit.setVotingEnabledStartTime(1L);

        voteLimitDao.save(voteLimit);

        LOGGER.info("votelimit save");

        VoteLimitService voteLimitService = (VoteLimitService) context.getBean("voteLimitService");
        voteLimit.setDescription("jjj");
        voteLimit.setTheme("jjj");
        voteLimitService.save(voteLimit);


        /*Vote vote = new Vote();
        vote.setDistrict(1);
        vote.setCreateTime(new Timestamp(new Date().getTime()));
        vote.setPassport("jjj");
        vote.setPlatform(2);
        vote.setSex(1);
        vote.setUid(123L);
        vote.setUpdateTime(new Timestamp(new Date().getTime()));
        vote.setVoteCount(123L);

        VoteDao voteDao = (VoteDao) context.getBean("voteDao");
        voteDao.save(vote);
        Voting voting = new Voting();
        voting.setDescription("fakdhf");
        voting.setSharingText("jasdfad");

        VotingDao votingDao= (VotingDao) context.getBean("votingDao");
        votingDao.save(voting);
*/



    }

}
