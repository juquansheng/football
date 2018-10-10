package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballUser;
import com.yicuojin.football.dao.FootballUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FootballUserMapper {
    int countByExample(FootballUserExample example);

    int deleteByExample(FootballUserExample example);

    int deleteByPrimaryKey(Integer weixinid);

    int insert(FootballUser record);

    int insertSelective(FootballUser record);

    List<FootballUser> selectByExample(FootballUserExample example);

    FootballUser selectByPrimaryKey(Integer weixinid);

    int updateByExampleSelective(@Param("record") FootballUser record, @Param("example") FootballUserExample example);

    int updateByExample(@Param("record") FootballUser record, @Param("example") FootballUserExample example);

    int updateByPrimaryKeySelective(FootballUser record);

    int updateByPrimaryKey(FootballUser record);
}