package com.yicuojin.football.service.Impl;

import com.yicuojin.football.dao.*;
import com.yicuojin.football.mapper.*;
import com.yicuojin.football.service.IRedeemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RedeemService implements IRedeemService {
    @Autowired
    private FootballRedeemCodeMapper footballRedeemCodeMapper;
    @Autowired
    private FootballAmountMapper footballAmountMapper;
    @Autowired
    private FootballBallParamMapper footballBallParamMapper;
    @Autowired
    private FootballRedeemGoodsMapper footballRedeemGoodsMapper;
    @Autowired
    private FootballRedeemItemMapper footballRedeemItemMapper;
    @Autowired
    private FootballAmountRecordMapper footballAmountRecordMapper;

    @Override
    public String generateRedeemCode(Integer userId, Integer redeemGoodsId, BigDecimal appAccount) {

        //判断用户兑换余额是否不足
        FootballAmountExample footballAmountExample = new FootballAmountExample();
        footballAmountExample.createCriteria().andUseridEqualTo(userId);
        List<FootballAmount> footballAmountList = footballAmountMapper.selectByExample(footballAmountExample);
        FootballRedeemGoods footballRedeemGoods = footballRedeemGoodsMapper.selectByPrimaryKey(redeemGoodsId);
        if (footballAmountList.size() > 0 && footballRedeemGoods != null &&
                footballAmountList.get(0).getTotalamount().compareTo(appAccount.multiply(footballRedeemGoods.getPrice())) >= 0) {
            FootballRedeemCode footballRedeemCode = new FootballRedeemCode();
            String uuidRandom = UUID.randomUUID().toString().replace("-", "");

            footballRedeemCode.setAppaccount(appAccount);
            footballRedeemCode.setRedeemcode(uuidRandom);
            footballRedeemCode.setRedeemgoodsid(redeemGoodsId);
            footballRedeemCode.setUserid(userId);
            footballRedeemCode.setCreatetime(new Date());
            boolean b = footballRedeemCodeMapper.insertSelective(footballRedeemCode) > 0;
            if (b) {
                //用户减少相应的积分
                BigDecimal sub = appAccount.multiply(footballRedeemGoods.getPrice());
                FootballAmount amount = footballAmountList.get(0);
                amount.setTotalamount(amount.getTotalamount().subtract(sub));
                footballAmountMapper.updateByPrimaryKeySelective(amount);
                //添加积分使用记录
                FootballAmountRecord footballAmountRecord = new FootballAmountRecord();
                footballAmountRecord.setAmount(sub);
                footballAmountRecord.setCreatetime(new Date());
                footballAmountRecord.setUserid(userId);
                footballAmountRecord.setType(4);
                footballAmountRecord.setStatus(1);
                footballAmountRecordMapper.insertSelective(footballAmountRecord);
                return uuidRandom;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    @Override
    public List<FootballRedeemCode> getRecord(Integer userid) {
        FootballRedeemCodeExample footballRedeemCodeExample = new FootballRedeemCodeExample();
        footballRedeemCodeExample.createCriteria().andUseridEqualTo(userid).andStatusNotEqualTo(-1);
        return footballRedeemCodeMapper.selectByExample(footballRedeemCodeExample);
    }

    @Override
    public List<FootballRedeemGoods> getGoodsByItemId(Integer itemId) {
        FootballRedeemGoodsExample footballRedeemGoodsExample = new FootballRedeemGoodsExample();
        footballRedeemGoodsExample.createCriteria().andItemidEqualTo(itemId).andStatusEqualTo(0);
        return footballRedeemGoodsMapper.selectByExample(footballRedeemGoodsExample);
    }

    @Override
    public List<FootballRedeemItem> getRedeemList() {
        FootballRedeemItemExample footballRedeemItemExample = new FootballRedeemItemExample();
        footballRedeemItemExample.createCriteria().andStatusEqualTo(0);
        return footballRedeemItemMapper.selectByExample(footballRedeemItemExample);
    }
}
