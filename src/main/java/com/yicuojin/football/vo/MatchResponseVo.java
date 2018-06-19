package com.yicuojin.football.vo;

import com.yicuojin.football.dao.FootballMessage;

import java.math.BigDecimal;
import java.util.List;

public class MatchResponseVo {
    private List<MatchInfoVo> matchInfoVoList;
    private boolean firstSign;
    private List<FootballMessage> footballMessageList;
    private Integer signCoin;
    private boolean messageNotNull;
    private BigDecimal totalAmount;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isMessageNotNull() {
        return messageNotNull;
    }

    public void setMessageNotNull(boolean messageNotNull) {
        this.messageNotNull = messageNotNull;
    }

    public Integer getSignCoin() {
        return signCoin;
    }

    public void setSignCoin(Integer signCoin) {
        this.signCoin = signCoin;
    }

    public List<MatchInfoVo> getMatchInfoVoList() {
        return matchInfoVoList;
    }

    public void setMatchInfoVoList(List<MatchInfoVo> matchInfoVoList) {
        this.matchInfoVoList = matchInfoVoList;
    }

    public boolean isFirstSign() {
        return firstSign;
    }

    public void setFirstSign(boolean firstSign) {
        this.firstSign = firstSign;
    }

    public List<FootballMessage> getFootballMessageList() {
        return footballMessageList;
    }

    public void setFootballMessageList(List<FootballMessage> footballMessageList) {
        this.footballMessageList = footballMessageList;
    }
}
