package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballMatch;
import com.yicuojin.football.dao.FootballMatchExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FootballMatchMapper {
    int countByExample(FootballMatchExample example);

    int deleteByExample(FootballMatchExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballMatch record);

    int insertSelective(FootballMatch record);

    List<FootballMatch> selectByExample(FootballMatchExample example);

    FootballMatch selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballMatch record, @Param("example") FootballMatchExample example);

    int updateByExample(@Param("record") FootballMatch record, @Param("example") FootballMatchExample example);

    int updateByPrimaryKeySelective(FootballMatch record);

    int updateByPrimaryKey(FootballMatch record);
}