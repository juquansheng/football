package com.yicuojin.football.vo;

import com.yicuojin.football.dao.FootballPlayerInfo;

import java.util.List;

public class TeamVo {

    private String name;

    private String teamdescribe;

    private String image;

    private List<FootballPlayerInfo> playerInfoList;
    private List<MatchInfoVo> matchInfoVoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamdescribe() {
        return teamdescribe;
    }

    public void setTeamdescribe(String teamdescribe) {
        this.teamdescribe = teamdescribe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<FootballPlayerInfo> getPlayerInfoList() {
        return playerInfoList;
    }

    public void setPlayerInfoList(List<FootballPlayerInfo> playerInfoList) {
        this.playerInfoList = playerInfoList;
    }

    public List<MatchInfoVo> getMatchInfoVoList() {
        return matchInfoVoList;
    }

    public void setMatchInfoVoList(List<MatchInfoVo> matchInfoVoList) {
        this.matchInfoVoList = matchInfoVoList;
    }
}
