package com.yicuojin.football.dao;

import java.math.BigDecimal;
import java.util.Date;

public class FootballGuessRecord {
    private Integer id;

    private Integer userid;

    private Integer matchid;

    private Integer userguess;

    private Integer matchresult;

    private Integer status;

    private BigDecimal bets;

    private BigDecimal reward;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMatchid() {
        return matchid;
    }

    public void setMatchid(Integer matchid) {
        this.matchid = matchid;
    }

    public Integer getUserguess() {
        return userguess;
    }

    public void setUserguess(Integer userguess) {
        this.userguess = userguess;
    }

    public Integer getMatchresult() {
        return matchresult;
    }

    public void setMatchresult(Integer matchresult) {
        this.matchresult = matchresult;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getBets() {
        return bets;
    }

    public void setBets(BigDecimal bets) {
        this.bets = bets;
    }

    public BigDecimal getReward() {
        return reward;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}