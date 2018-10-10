package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballTeamInfo;
import com.yicuojin.football.dao.FootballTeamInfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FootballTeamInfoMapper {
    int countByExample(FootballTeamInfoExample example);

    int deleteByExample(FootballTeamInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballTeamInfo record);

    int insertSelective(FootballTeamInfo record);

    List<FootballTeamInfo> selectByExample(FootballTeamInfoExample example);

    FootballTeamInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballTeamInfo record, @Param("example") FootballTeamInfoExample example);

    int updateByExample(@Param("record") FootballTeamInfo record, @Param("example") FootballTeamInfoExample example);

    int updateByPrimaryKeySelective(FootballTeamInfo record);

    int updateByPrimaryKey(FootballTeamInfo record);
}