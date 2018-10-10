package com.yicuojin.football.service.Impl;

import com.google.common.collect.Lists;
import com.yicuojin.football.dao.*;
import com.yicuojin.football.mapper.FootballMatchMapper;
import com.yicuojin.football.mapper.FootballPlayerInfoMapper;
import com.yicuojin.football.mapper.FootballTeamInfoMapper;
import com.yicuojin.football.service.ITeamService;
import com.yicuojin.football.vo.MatchInfoVo;
import com.yicuojin.football.vo.TeamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private FootballTeamInfoMapper footballTeamInfoMapper;
    @Autowired
    private FootballPlayerInfoMapper footballPlayerInfoMapper;
    @Autowired
    private FootballMatchMapper footballMatchMapper;

    @Override
    public TeamVo getTeamVo(Integer teamId) {
        TeamVo teamVo = new TeamVo();
        //获取球队信息
        FootballTeamInfo footballTeamInfo = footballTeamInfoMapper.selectByPrimaryKey(teamId);
        if (footballTeamInfo != null) {
            FootballPlayerInfoExample footballPlayerInfoExample = new FootballPlayerInfoExample();
            //添加球员信息列表
            footballPlayerInfoExample.createCriteria().andTeamidEqualTo(footballTeamInfo.getId()).andStatusEqualTo(0);
            footballPlayerInfoExample.setOrderByClause("Id desc");
            List<FootballPlayerInfo> footballPlayerInfoList = footballPlayerInfoMapper.selectByExample(footballPlayerInfoExample);
            List<FootballPlayerInfo> footballPlayerInfoListVo = Lists.newArrayList();
            for (FootballPlayerInfo footballPlayerInfo : footballPlayerInfoList) {
                footballPlayerInfo.setImg("https://tjb.yunxinyong.net/football-0.0.1-SNAPSHOT/image/" + footballPlayerInfo.getImg() + ".png");
                footballPlayerInfo.setData("https://tjb.yunxinyong.net/football-0.0.1-SNAPSHOT/image/" + footballPlayerInfo.getData() + ".png");
                footballPlayerInfoListVo.add(footballPlayerInfo);

            }
            teamVo.setPlayerInfoList(footballPlayerInfoListVo);
            //添加包含球队的未开始比赛信息
            FootballMatchExample AfootballMatchExample = new FootballMatchExample();
            AfootballMatchExample.createCriteria().andTeamaEqualTo(footballTeamInfo.getId());

            FootballMatchExample BfootballMatchExample = new FootballMatchExample();
            BfootballMatchExample.createCriteria().andTeambEqualTo(footballTeamInfo.getId());

            List<FootballMatch> AfootballMatches = footballMatchMapper.selectByExample(AfootballMatchExample);
            List<FootballMatch> BfootballMatches = footballMatchMapper.selectByExample(BfootballMatchExample);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            BfootballMatches.addAll(AfootballMatches);
            List<MatchInfoVo> matchInfoVoList = Lists.newArrayList();
            for (FootballMatch footballMatch : BfootballMatches) {
                MatchInfoVo matchInfoVo = new MatchInfoVo();
                footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeamb());
                matchInfoVo.setTeama(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeama()).getName());
                matchInfoVo.setTeamb(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeamb()).getName());
                matchInfoVo.setStarttime(format.format(footballMatch.getStarttime()));
                matchInfoVo.setAddr(footballMatch.getAddr());
                matchInfoVo.setScorea(footballMatch.getScorea());
                matchInfoVo.setScoreb(footballMatch.getScoreb());
                matchInfoVo.setResult(footballMatch.getResult());
                matchInfoVo.setType(footballMatch.getType());
                matchInfoVo.setAurl(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeama()).getImage());
                matchInfoVo.setBurl(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeamb()).getImage());
                matchInfoVoList.add(matchInfoVo);

            }
            teamVo.setMatchInfoVoList(matchInfoVoList);

            teamVo.setImage(footballTeamInfo.getImage());
            teamVo.setName(footballTeamInfo.getName());
            teamVo.setTeamdescribe(footballTeamInfo.getTeamdescribe());
        }
        return teamVo;
    }
}
