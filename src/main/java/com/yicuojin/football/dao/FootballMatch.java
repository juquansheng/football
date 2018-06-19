package com.yicuojin.football.dao;

import java.math.BigDecimal;
import java.util.Date;

public class FootballMatch {
    private Integer id;

    private Integer teama;

    private Integer teamb;

    private BigDecimal prate;

    private BigDecimal brate;

    private BigDecimal arate;

    private Integer scorea;

    private Integer scoreb;

    private Integer result;

    private Integer type;

    private Date createtime;

    private Date uptetime;

    private Date starttime;

    private Date endtime;

    private String addr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeama() {
        return teama;
    }

    public void setTeama(Integer teama) {
        this.teama = teama;
    }

    public Integer getTeamb() {
        return teamb;
    }

    public void setTeamb(Integer teamb) {
        this.teamb = teamb;
    }

    public BigDecimal getPrate() {
        return prate;
    }

    public void setPrate(BigDecimal prate) {
        this.prate = prate;
    }

    public BigDecimal getBrate() {
        return brate;
    }

    public void setBrate(BigDecimal brate) {
        this.brate = brate;
    }

    public BigDecimal getArate() {
        return arate;
    }

    public void setArate(BigDecimal arate) {
        this.arate = arate;
    }

    public Integer getScorea() {
        return scorea;
    }

    public void setScorea(Integer scorea) {
        this.scorea = scorea;
    }

    public Integer getScoreb() {
        return scoreb;
    }

    public void setScoreb(Integer scoreb) {
        this.scoreb = scoreb;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUptetime() {
        return uptetime;
    }

    public void setUptetime(Date uptetime) {
        this.uptetime = uptetime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }
}