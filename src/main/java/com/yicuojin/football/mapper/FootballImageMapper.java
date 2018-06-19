package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballImage;
import com.yicuojin.football.dao.FootballImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootballImageMapper {
    int countByExample(FootballImageExample example);

    int deleteByExample(FootballImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballImage record);

    int insertSelective(FootballImage record);

    List<FootballImage> selectByExample(FootballImageExample example);

    FootballImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballImage record, @Param("example") FootballImageExample example);

    int updateByExample(@Param("record") FootballImage record, @Param("example") FootballImageExample example);

    int updateByPrimaryKeySelective(FootballImage record);

    int updateByPrimaryKey(FootballImage record);
}