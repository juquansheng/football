package com.yicuojin.football.service.Impl;

import com.yicuojin.football.dao.FootballAmount;
import com.yicuojin.football.dao.FootballAmountExample;
import com.yicuojin.football.dao.FootballRedeemCode;
import com.yicuojin.football.dao.FootballRedeemCodeExample;
import com.yicuojin.football.mapper.FootballAmountMapper;
import com.yicuojin.football.mapper.FootballBallParamMapper;
import com.yicuojin.football.mapper.FootballRedeemCodeMapper;
import com.yicuojin.football.service.IRedeemCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RedeemCodeService implements IRedeemCodeService {
    @Autowired
    private FootballRedeemCodeMapper footballRedeemCodeMapper;
    @Autowired
    private FootballAmountMapper footballAmountMapper;
    @Autowired
    private FootballBallParamMapper footballBallParamMapper;
    @Override
    public String generateRedeemCode(Integer userId,Integer type,BigDecimal appAccount) {
        BigDecimal rate = BigDecimal.ONE;
        if (type == 0){
            rate = new BigDecimal(footballBallParamMapper.selectByPrimaryKey(10).getValue());
        }else if (type == 1){
            rate = new BigDecimal(footballBallParamMapper.selectByPrimaryKey(8).getValue());
        }else if (type == 2){
            rate = new BigDecimal(footballBallParamMapper.selectByPrimaryKey(9).getValue());
        }
        //判断用户兑换余额是否不足
        FootballAmountExample footballAmountExample = new FootballAmountExample();
        footballAmountExample.createCriteria().andUseridEqualTo(userId);
        List<FootballAmount> footballAmountList = footballAmountMapper.selectByExample(footballAmountExample);
        if (footballAmountList.size() > 0 && footballAmountList.get(0).getTotalamount().compareTo(appAccount.multiply(rate)) >= 0){
            FootballRedeemCode footballRedeemCode = new FootballRedeemCode();
            String uuidRandom = UUID.randomUUID().toString().replace("-", "");

            footballRedeemCode.setAppaccount(appAccount);
            footballRedeemCode.setRedeemcode(uuidRandom);
            footballRedeemCode.setUserid(userId);
            footballRedeemCode.setType(type);
            footballRedeemCode.setCreatetime(new Date());
            boolean b = footballRedeemCodeMapper.insertSelective(footballRedeemCode) > 0;
            if (b){
                //用户减少相应的积分
                BigDecimal sub = appAccount.multiply(rate);
                FootballAmount amount = footballAmountList.get(0);
                amount.setTotalamount(amount.getTotalamount().subtract(sub));
                footballAmountMapper.updateByPrimaryKeySelective(amount);
                return uuidRandom;
            }else {
                return null;
            }
        }else {
            return null;
        }

    }

    @Override
    public List<FootballRedeemCode> getRecord(Integer userid) {
        FootballRedeemCodeExample footballRedeemCodeExample = new FootballRedeemCodeExample();
        footballRedeemCodeExample.createCriteria().andUseridEqualTo(userid).andStatusNotEqualTo(-1);
        List<FootballRedeemCode> footballRedeemCodes = footballRedeemCodeMapper.selectByExample(footballRedeemCodeExample);
        return footballRedeemCodes;
    }
}
