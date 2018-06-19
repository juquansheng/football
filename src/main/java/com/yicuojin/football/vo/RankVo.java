package com.yicuojin.football.vo;

import java.math.BigDecimal;

public class RankVo {
    private BigDecimal amount;
    private Integer userId;
    private String head;
    private Integer rank;
    private Integer isMe;
    private String name;

    public Integer getIsMe() {
        return isMe;
    }

    public void setIsMe(Integer isMe) {
        this.isMe = isMe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
