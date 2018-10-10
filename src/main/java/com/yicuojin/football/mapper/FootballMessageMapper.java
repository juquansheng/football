package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballMessage;
import com.yicuojin.football.dao.FootballMessageExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FootballMessageMapper {
    int countByExample(FootballMessageExample example);

    int deleteByExample(FootballMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballMessage record);

    int insertSelective(FootballMessage record);

    List<FootballMessage> selectByExample(FootballMessageExample example);

    FootballMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballMessage record, @Param("example") FootballMessageExample example);

    int updateByExample(@Param("record") FootballMessage record, @Param("example") FootballMessageExample example);

    int updateByPrimaryKeySelective(FootballMessage record);

    int updateByPrimaryKey(FootballMessage record);
}