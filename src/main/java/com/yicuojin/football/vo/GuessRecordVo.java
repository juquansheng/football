package com.yicuojin.football.vo;

import java.math.BigDecimal;
import java.util.Date;

public class GuessRecordVo {
    private Integer id;

    private Integer userid;

    private Integer matchid;

    private Integer userguess;

    private Integer matchresult;

    private Integer status;
    private BigDecimal bets;

    private BigDecimal reward;

    private String createtime;
    private String updateTime;
    private String Aname;
    private String Bname;
    private Integer Ascore;
    private Integer Bscore;
    private String aFlag;
    private String bFlag;
    private String describe;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getaFlag() {
        return aFlag;
    }

    public void setaFlag(String aFlag) {
        this.aFlag = aFlag;
    }

    public String getbFlag() {
        return bFlag;
    }

    public void setbFlag(String bFlag) {
        this.bFlag = bFlag;
    }

    public BigDecimal getBets() {
        return bets;
    }
    public void setBets(BigDecimal bets) {
        this.bets = bets;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getAname() {
        return Aname;
    }

    public void setAname(String aname) {
        Aname = aname;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public Integer getAscore() {
        return Ascore;
    }

    public void setAscore(Integer ascore) {
        Ascore = ascore;
    }

    public Integer getBscore() {
        return Bscore;
    }

    public void setBscore(Integer bscore) {
        Bscore = bscore;
    }

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

    public BigDecimal getReward() {
        return reward;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
