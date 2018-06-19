package com.yicuojin.football.dao;

import java.math.BigDecimal;

public class FootballMatchReward {
    private Integer id;

    private Integer matchid;

    private BigDecimal aacount;

    private BigDecimal bacount;

    private BigDecimal cacount;

    private BigDecimal reward;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatchid() {
        return matchid;
    }

    public void setMatchid(Integer matchid) {
        this.matchid = matchid;
    }

    public BigDecimal getAacount() {
        return aacount;
    }

    public void setAacount(BigDecimal aacount) {
        this.aacount = aacount;
    }

    public BigDecimal getBacount() {
        return bacount;
    }

    public void setBacount(BigDecimal bacount) {
        this.bacount = bacount;
    }

    public BigDecimal getCacount() {
        return cacount;
    }

    public void setCacount(BigDecimal cacount) {
        this.cacount = cacount;
    }

    public BigDecimal getReward() {
        return reward;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }
}