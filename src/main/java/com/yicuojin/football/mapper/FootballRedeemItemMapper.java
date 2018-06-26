package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballRedeemItem;
import com.yicuojin.football.dao.FootballRedeemItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootballRedeemItemMapper {
    int countByExample(FootballRedeemItemExample example);

    int deleteByExample(FootballRedeemItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballRedeemItem record);

    int insertSelective(FootballRedeemItem record);

    List<FootballRedeemItem> selectByExample(FootballRedeemItemExample example);

    FootballRedeemItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballRedeemItem record, @Param("example") FootballRedeemItemExample example);

    int updateByExample(@Param("record") FootballRedeemItem record, @Param("example") FootballRedeemItemExample example);

    int updateByPrimaryKeySelective(FootballRedeemItem record);

    int updateByPrimaryKey(FootballRedeemItem record);
}