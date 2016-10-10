/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: Voting.java
 * @package com.sohu.tv.digg.vote.model
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午6:49:53
 * @version V1.0
 *
 */
package com.sohu.tv.digg.vote.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @className: Voting
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午6:49:53
 * @version V1.0
 *
 */
@Document(collection = "voting")
public class Voting implements Serializable{
    private static final long serialVersionUID = 4326061403049834938L;

    /**
     * 播放器使用，当播放器播放到某几秒的时候，显示投票
     */
    private Integer actionTime;

    private long createTime;

    /**
     * 投票描述
     */
    private String description;

    /**
     * 自增id,用于兼容之前mysql投票架构以及以后扩展为不同的投票项目使用的id
     */
    @Id
    private Long id;

    private Integer isLogin;

    /**
     * 分享到sina weibo的文案
     */
    private String shareToWeiboText;

    /**
     * 分享文案
     */
    private String sharingText;

    /**
     * 标记是在页面显示 或是在播放器显示,0表示在播放器显示，1表示在播放页显示
     */
    private Integer source;

    private String theme;

    /**
     * 用于标记投票类别， 0-单选，1-多选，2-pk，3-人物投票
     */
    private Integer type;

    private long updateTime;

    /**
     * 是否记录投票选项的记录
     */
    private Integer voteRecorded;

    private Long votingEnabledCount;

    private Long votingEnabledEndTime;

    private Long votingEnabledStartTime;

    public Integer getActionTime() {
        if (actionTime == null)
            return 0;
        return actionTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public Integer getIsLogin() {

        return isLogin == null ? 0 : isLogin;
    }
    public String getShareToWeiboText() {
        return shareToWeiboText;
    }

    public String getSharingText() {
        return sharingText;
    }

    public Integer getSource() {
        return source;
    }

    public String getTheme() {
        return theme;
    }

    public Integer getType() {
        return type;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public Integer getVoteRecorded() {
        return voteRecorded == null ? 0 : voteRecorded;
    }

    public Long getVotingEnabledCount() {
        return votingEnabledCount == null ? 0 : votingEnabledCount;
    }

    public Long getVotingEnabledEndTime() {
        return votingEnabledEndTime == null ? 0 : votingEnabledEndTime;
    }

    public Long getVotingEnabledStartTime() {
        return votingEnabledStartTime == null ? 0L : votingEnabledStartTime;
    }

    public void setActionTime(Integer actionTime) {
        this.actionTime = actionTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }

    public void setShareToWeiboText(String shareToWeiboText) {
        this.shareToWeiboText = shareToWeiboText;
    }

    public void setSharingText(String sharingText) {
        this.sharingText = sharingText;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public void setVoteRecorded(Integer voteRecorded) {
        this.voteRecorded = voteRecorded;
    }

    public void setVotingEnabledCount(Long votingEnabledCount) {
        this.votingEnabledCount = votingEnabledCount;
    }

    public void setVotingEnabledEndTime(Long votingEnabledEndTime) {
        this.votingEnabledEndTime = votingEnabledEndTime;
    }

    public void setVotingEnabledStartTime(Long votingEnabledStartTime) {
        this.votingEnabledStartTime = votingEnabledStartTime;
    }
}
