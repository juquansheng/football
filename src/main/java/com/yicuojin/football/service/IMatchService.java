package com.yicuojin.football.service;

import com.yicuojin.football.vo.MatchInfoVo;

import java.math.BigDecimal;
import java.util.List;

public interface IMatchService {

    /**
     * 返回用户竞猜页列表
     * @param userID
     * @return
     */
    List<MatchInfoVo> getUserMatchList(Integer userID);
    /**
     * 结算
     */
    boolean Settlement(Integer id);
    /**
     * 更新所有比赛状态
     */
    boolean matechResult();


    /**
     * 返回用户竞猜页列表(用户选择下注)
     * @param userID
     * @return
     */
    List<MatchInfoVo> getUserMatchList1(Integer userID);
    /**
     * 用户下注(用户选择下注)
     */
    boolean userChoice(Integer userId, Integer matchId, Integer userGuess, BigDecimal bet);
    /**
     * 结算
     */
    void Settlement1();
}
