package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballSign;
import com.yicuojin.football.dao.FootballSignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootballSignMapper {
    int countByExample(FootballSignExample example);

    int deleteByExample(FootballSignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballSign record);

    int insertSelective(FootballSign record);

    List<FootballSign> selectByExample(FootballSignExample example);

    FootballSign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballSign record, @Param("example") FootballSignExample example);

    int updateByExample(@Param("record") FootballSign record, @Param("example") FootballSignExample example);

    int updateByPrimaryKeySelective(FootballSign record);

    int updateByPrimaryKey(FootballSign record);
}