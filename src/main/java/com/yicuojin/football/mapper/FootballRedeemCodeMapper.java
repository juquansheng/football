package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballRedeemCode;
import com.yicuojin.football.dao.FootballRedeemCodeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FootballRedeemCodeMapper {
    int countByExample(FootballRedeemCodeExample example);

    int deleteByExample(FootballRedeemCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballRedeemCode record);

    int insertSelective(FootballRedeemCode record);

    List<FootballRedeemCode> selectByExample(FootballRedeemCodeExample example);

    FootballRedeemCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballRedeemCode record, @Param("example") FootballRedeemCodeExample example);

    int updateByExample(@Param("record") FootballRedeemCode record, @Param("example") FootballRedeemCodeExample example);

    int updateByPrimaryKeySelective(FootballRedeemCode record);

    int updateByPrimaryKey(FootballRedeemCode record);
}