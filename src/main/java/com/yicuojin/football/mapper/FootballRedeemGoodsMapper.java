package com.yicuojin.football.mapper;

import com.yicuojin.football.dao.FootballRedeemGoods;
import com.yicuojin.football.dao.FootballRedeemGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootballRedeemGoodsMapper {
    int countByExample(FootballRedeemGoodsExample example);

    int deleteByExample(FootballRedeemGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootballRedeemGoods record);

    int insertSelective(FootballRedeemGoods record);

    List<FootballRedeemGoods> selectByExample(FootballRedeemGoodsExample example);

    FootballRedeemGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootballRedeemGoods record, @Param("example") FootballRedeemGoodsExample example);

    int updateByExample(@Param("record") FootballRedeemGoods record, @Param("example") FootballRedeemGoodsExample example);

    int updateByPrimaryKeySelective(FootballRedeemGoods record);

    int updateByPrimaryKey(FootballRedeemGoods record);
}