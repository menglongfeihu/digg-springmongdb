/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: VoteLimit.java
 * @package com.sohu.tv.digg.vote.model
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午3:58:14
 * @version V1.0
 *
 */
package com.sohu.tv.digg.vote.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @className: VoteLimit
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午3:58:14
 * @version V1.0
 *
 */
@Document(collection = "votelimit")
@CompoundIndex(name = "platform_theme_idx", def = "{'platform':1,'theme':1}")
public class VoteLimit implements Serializable {

    private static final long serialVersionUID = 3223853210606353381L;

    @Indexed(direction = IndexDirection.ASCENDING, name = "theme_idx")
    private String theme;

    private Integer count;

    private String description;

    @Indexed(direction = IndexDirection.ASCENDING,  name = "platform_idx", unique = true, dropDups = true)
    private Integer platform;

    private Integer needLogin;

    private Timestamp createTime;

    private Long votingEnabledStartTime;

    private Long votingEnabledEndTime;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Integer getNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(Integer needLogin) {
        this.needLogin = needLogin;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getVotingEnabledStartTime() {
        return votingEnabledStartTime;
    }

    public void setVotingEnabledStartTime(Long votingEnabledStartTime) {
        this.votingEnabledStartTime = votingEnabledStartTime;
    }

    public Long getVotingEnabledEndTime() {
        return votingEnabledEndTime;
    }

    public void setVotingEnabledEndTime(Long votingEnabledEndTime) {
        this.votingEnabledEndTime = votingEnabledEndTime;
    }

    @Override
    public String toString() {
        return "VoteLimit [theme=" + theme + ", count=" + count + ", description=" + description
                + ", platform=" + platform + ", needLogin=" + needLogin + ", createTime=" + createTime
                + ", votingEnabledStartTime=" + votingEnabledStartTime + ", votingEnabledEndTime="
                + votingEnabledEndTime + "]";
    }


}
