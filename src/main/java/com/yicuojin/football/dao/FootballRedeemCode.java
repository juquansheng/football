package com.yicuojin.football.dao;

import java.math.BigDecimal;
import java.util.Date;

public class FootballRedeemCode {
    private Integer id;

    private Integer userid;

    private Integer useid;

    private Integer redeemgoodsid;

    private String redeemcode;

    private Integer type;

    private BigDecimal appaccount;

    private String redeemdescr;

    private Integer status;

    private Date createtime;

    private Date usetime;

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

    public Integer getUseid() {
        return useid;
    }

    public void setUseid(Integer useid) {
        this.useid = useid;
    }

    public Integer getRedeemgoodsid() {
        return redeemgoodsid;
    }

    public void setRedeemgoodsid(Integer redeemgoodsid) {
        this.redeemgoodsid = redeemgoodsid;
    }

    public String getRedeemcode() {
        return redeemcode;
    }

    public void setRedeemcode(String redeemcode) {
        this.redeemcode = redeemcode == null ? null : redeemcode.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getAppaccount() {
        return appaccount;
    }

    public void setAppaccount(BigDecimal appaccount) {
        this.appaccount = appaccount;
    }

    public String getRedeemdescr() {
        return redeemdescr;
    }

    public void setRedeemdescr(String redeemdescr) {
        this.redeemdescr = redeemdescr == null ? null : redeemdescr.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUsetime() {
        return usetime;
    }

    public void setUsetime(Date usetime) {
        this.usetime = usetime;
    }
}