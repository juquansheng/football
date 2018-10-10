package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballAmount;
import com.yicuojin.football.dao.FootballAmountExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FootballAmountMapper {
    int countByExample(FootballAmountExample example);

    int deleteByExample(FootballAmountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballAmount record);

    int insertSelective(FootballAmount record);

    List<FootballAmount> selectByExample(FootballAmountExample example);

    FootballAmount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballAmount record, @Param("example") FootballAmountExample example);

    int updateByExample(@Param("record") FootballAmount record, @Param("example") FootballAmountExample example);

    int updateByPrimaryKeySelective(FootballAmount record);

    int updateByPrimaryKey(FootballAmount record);

    List<FootballAmount> selectRank();
}