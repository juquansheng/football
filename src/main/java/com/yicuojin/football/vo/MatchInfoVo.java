package com.yicuojin.football.vo;

import java.math.BigDecimal;
import java.util.Date;

public class MatchInfoVo {
    private Integer id;

    //球队a名称
    private String teama;
    //球队b名称
    private String teamb;
    //球队a的得分
    private Integer scorea;
    //球队b得分
    private Integer scoreb;
    //比赛状态 -1未开始竞猜0开始竞猜未完成 4结束竞猜 1.A赢  2.B赢 3.平局
    private Integer result;
    //比赛类型
    private Integer type;

    private String aurl;
    private String burl;
    //是否已经竞猜 0未竞猜  其他事竞猜的队伍
    private Integer choice;
    private BigDecimal countA;
    private BigDecimal countB;
    private BigDecimal countC;
    private String starttime;
    private String endtime;
    private String addr;
    private Integer idA;
    private Integer idB;
    private BigDecimal prate;

    private BigDecimal brate;

    private BigDecimal arate;

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

    public Integer getIdA() {
        return idA;
    }

    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    public Integer getIdB() {
        return idB;
    }

    public void setIdB(Integer idB) {
        this.idB = idB;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getTeama() {
        return teama;
    }

    public void setTeama(String teama) {
        this.teama = teama;
    }

    public String getTeamb() {
        return teamb;
    }

    public void setTeamb(String teamb) {
        this.teamb = teamb;
    }


    public BigDecimal getCountA() {
        return countA;
    }

    public void setCountA(BigDecimal countA) {
        this.countA = countA;
    }

    public BigDecimal getCountB() {
        return countB;
    }

    public void setCountB(BigDecimal countB) {
        this.countB = countB;
    }

    public BigDecimal getCountC() {
        return countC;
    }

    public void setCountC(BigDecimal countC) {
        this.countC = countC;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl;
    }

    public String getBurl() {
        return burl;
    }

    public void setBurl(String burl) {
        this.burl = burl;
    }

    public Integer getChoice() {
        return choice;
    }

    public void setChoice(Integer choice) {
        this.choice = choice;
    }
}
