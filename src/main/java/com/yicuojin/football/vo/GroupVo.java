package com.yicuojin.football.vo;

import com.yicuojin.football.dao.FootballTeamInfo;

import java.util.List;

public class GroupVo {
    private Integer groupId;
    private String groupName;
    private List<FootballTeamInfo> footballTeamInfoList;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<FootballTeamInfo> getFootballTeamInfoList() {
        return footballTeamInfoList;
    }

    public void setFootballTeamInfoList(List<FootballTeamInfo> footballTeamInfoList) {
        this.footballTeamInfoList = footballTeamInfoList;
    }
}
