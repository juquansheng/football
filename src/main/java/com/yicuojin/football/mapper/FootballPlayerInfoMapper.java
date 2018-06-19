package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballPlayerInfo;
import com.yicuojin.football.dao.FootballPlayerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootballPlayerInfoMapper {
    int countByExample(FootballPlayerInfoExample example);

    int deleteByExample(FootballPlayerInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballPlayerInfo record);

    int insertSelective(FootballPlayerInfo record);

    List<FootballPlayerInfo> selectByExample(FootballPlayerInfoExample example);

    FootballPlayerInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballPlayerInfo record, @Param("example") FootballPlayerInfoExample example);

    int updateByExample(@Param("record") FootballPlayerInfo record, @Param("example") FootballPlayerInfoExample example);

    int updateByPrimaryKeySelective(FootballPlayerInfo record);

    int updateByPrimaryKey(FootballPlayerInfo record);
}