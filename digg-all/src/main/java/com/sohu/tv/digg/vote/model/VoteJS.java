/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: VoteJs.java
 * @package com.sohu.tv.digg.vote.model
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午6:05:45
 * @version V1.0
 *
 */
package com.sohu.tv.digg.vote.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @className: VoteJs
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午6:05:45
 * @version V1.0
 *
 */
@Document(collection = "votejs")
public class VoteJS implements Serializable{
    /**
     *
     */
    //期数、手机、队伍、时间、昵称
    private static final long serialVersionUID = -7795688132844357121L;

    @Indexed(unique = false)
    private Integer issue;

    private Integer teamid;

    private Long createtime;

    private Long updatetime;

    private Long votecount;

    private Integer status; //team 状态  0:normal  1:winner 2:loser

    private String img;

    public Integer getIssue() {
        return issue;
    }

    public void setIssue(Integer issue) {
        this.issue = issue;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    public Long getVotecount() {
        return votecount;
    }

    public void setVotecount(Long votecount) {
        this.votecount = votecount;
    }

    public Integer getTeamid() {
        return teamid;
    }

    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "VoteJS [issue=" + issue + ", teamid=" + teamid + ", createtime=" + createtime + ", updatetime="
                + updatetime + ", votecount=" + votecount + ", status=" + status + ", img=" + img + "]";
    }
}
