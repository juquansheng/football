package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballBallParam;
import com.yicuojin.football.dao.FootballBallParamExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FootballBallParamMapper {
    int countByExample(FootballBallParamExample example);

    int deleteByExample(FootballBallParamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballBallParam record);

    int insertSelective(FootballBallParam record);

    List<FootballBallParam> selectByExample(FootballBallParamExample example);

    FootballBallParam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballBallParam record, @Param("example") FootballBallParamExample example);

    int updateByExample(@Param("record") FootballBallParam record, @Param("example") FootballBallParamExample example);

    int updateByPrimaryKeySelective(FootballBallParam record);

    int updateByPrimaryKey(FootballBallParam record);
}