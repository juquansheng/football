package com.yicuojin.football.dao;

import java.util.Date;

public class FootballShare {
    private Integer id;

    private Integer userid;

    private Integer reciveid;

    private Date createtime;

    private Integer status;

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

    public Integer getReciveid() {
        return reciveid;
    }

    public void setReciveid(Integer reciveid) {
        this.reciveid = reciveid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}