package com.yicuojin.football.dao;

import java.util.Date;

public class FootballTeamInfo {
    private Integer id;

    private String name;

    private String teamdescribe;

    private Date createtime;

    private Date updatetime;

    private String image;

    private Integer status;

    private Integer groupid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTeamdescribe() {
        return teamdescribe;
    }

    public void setTeamdescribe(String teamdescribe) {
        this.teamdescribe = teamdescribe == null ? null : teamdescribe.trim();
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }
}