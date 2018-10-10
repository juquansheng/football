package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballGuessRecord;
import com.yicuojin.football.dao.FootballGuessRecordExample;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FootballGuessRecordMapper {
    int countByExample(FootballGuessRecordExample example);

    int deleteByExample(FootballGuessRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballGuessRecord record);

    int insertSelective(FootballGuessRecord record);

    List<FootballGuessRecord> selectByExample(FootballGuessRecordExample example);

    FootballGuessRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballGuessRecord record, @Param("example") FootballGuessRecordExample example);

    int updateByExample(@Param("record") FootballGuessRecord record, @Param("example") FootballGuessRecordExample example);

    int updateByPrimaryKeySelective(FootballGuessRecord record);

    int updateByPrimaryKey(FootballGuessRecord record);

    BigDecimal countBetsByExample(FootballGuessRecordExample example);
}