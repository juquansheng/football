package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballGroup;
import com.yicuojin.football.dao.FootballGroupExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FootballGroupMapper {
    int countByExample(FootballGroupExample example);

    int deleteByExample(FootballGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballGroup record);

    int insertSelective(FootballGroup record);

    List<FootballGroup> selectByExample(FootballGroupExample example);

    FootballGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballGroup record, @Param("example") FootballGroupExample example);

    int updateByExample(@Param("record") FootballGroup record, @Param("example") FootballGroupExample example);

    int updateByPrimaryKeySelective(FootballGroup record);

    int updateByPrimaryKey(FootballGroup record);
}