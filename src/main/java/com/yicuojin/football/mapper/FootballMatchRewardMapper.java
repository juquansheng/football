package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballMatchReward;
import com.yicuojin.football.dao.FootballMatchRewardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootballMatchRewardMapper {
    int countByExample(FootballMatchRewardExample example);

    int deleteByExample(FootballMatchRewardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballMatchReward record);

    int insertSelective(FootballMatchReward record);

    List<FootballMatchReward> selectByExample(FootballMatchRewardExample example);

    FootballMatchReward selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballMatchReward record, @Param("example") FootballMatchRewardExample example);

    int updateByExample(@Param("record") FootballMatchReward record, @Param("example") FootballMatchRewardExample example);

    int updateByPrimaryKeySelective(FootballMatchReward record);

    int updateByPrimaryKey(FootballMatchReward record);
}