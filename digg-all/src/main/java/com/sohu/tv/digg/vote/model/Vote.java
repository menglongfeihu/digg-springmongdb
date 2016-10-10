/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: Vote.java
 * @package com.sohu.tv.digg.vote.model
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午3:31:03
 * @version V1.0
 *
 */
package com.sohu.tv.digg.vote.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @className: Vote
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午3:31:03
 * @version V1.0
 *
 */
@Document(collection = "vote")
public class Vote implements Serializable {

    private static final long serialVersionUID = -8394763582247994168L;

    @Indexed(unique = true)
    private Long uid;

    private String passport;

    private long createTime;

    private long updateTime;

    // player's district,sush as southeaset district,northeast district
    private Integer district;

    private Integer sex;

    private Long voteCount;

    // such as JD,TAOBAO,sohu ...default is 1==JD
    private Integer platform;



    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Vote [uid=" + uid + ", passport=" + passport + ", createTime=" + createTime
                + ", updateTime=" + updateTime + ", district=" + district + ", sex=" + sex + ", voteCount=" + voteCount
                + ", platform=" + platform + "]";
    }


}
