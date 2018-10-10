package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballShare;
import com.yicuojin.football.dao.FootballShareExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FootballShareMapper {
    int countByExample(FootballShareExample example);

    int deleteByExample(FootballShareExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballShare record);

    int insertSelective(FootballShare record);

    List<FootballShare> selectByExample(FootballShareExample example);

    FootballShare selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballShare record, @Param("example") FootballShareExample example);

    int updateByExample(@Param("record") FootballShare record, @Param("example") FootballShareExample example);

    int updateByPrimaryKeySelective(FootballShare record);

    int updateByPrimaryKey(FootballShare record);
}