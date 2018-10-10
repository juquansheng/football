package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballAmountRecord;
import com.yicuojin.football.dao.FootballAmountRecordExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FootballAmountRecordMapper {
    int countByExample(FootballAmountRecordExample example);

    int deleteByExample(FootballAmountRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballAmountRecord record);

    int insertSelective(FootballAmountRecord record);

    List<FootballAmountRecord> selectByExample(FootballAmountRecordExample example);

    FootballAmountRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballAmountRecord record, @Param("example") FootballAmountRecordExample example);

    int updateByExample(@Param("record") FootballAmountRecord record, @Param("example") FootballAmountRecordExample example);

    int updateByPrimaryKeySelective(FootballAmountRecord record);

    int updateByPrimaryKey(FootballAmountRecord record);
}