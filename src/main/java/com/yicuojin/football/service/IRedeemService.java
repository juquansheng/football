package com.yicuojin.football.service;

import com.yicuojin.football.dao.FootballRedeemCode;
import com.yicuojin.football.dao.FootballRedeemGoods;
import com.yicuojin.football.dao.FootballRedeemItem;

import java.math.BigDecimal;
import java.util.List;

public interface IRedeemService {
    /**
     * 生成兑换码
     *
     * @param userid
     * @param redeemGoodsId
     * @param appaccount
     * @return
     */
    String generateRedeemCode(Integer userid, Integer redeemGoodsId, BigDecimal appaccount);

    /**
     * 兑换记录
     *
     * @param userid
     * @return
     */
    List<FootballRedeemCode> getRecord(Integer userid);

    /**
     * 根据兑换项目获取商品列表
     *
     * @param itemId
     * @return
     */
    List<FootballRedeemGoods> getGoodsByItemId(Integer itemId);

    /**
     * 获取兑换项目列表
     *
     * @return
     */
    List<FootballRedeemItem> getRedeemList();
}
