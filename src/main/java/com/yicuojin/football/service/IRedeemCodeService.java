package com.yicuojin.football.service;

import com.yicuojin.football.dao.FootballRedeemCode;

import java.math.BigDecimal;
import java.util.List;

public interface IRedeemCodeService {
    String generateRedeemCode(Integer userid,Integer type,BigDecimal appaccount);
    List<FootballRedeemCode> getRecord(Integer userid);
}
