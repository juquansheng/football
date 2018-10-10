package com.yicuojin.football.service.Impl;

import com.yicuojin.football.dao.*;
import com.yicuojin.football.mapper.*;
import com.yicuojin.football.service.IShareService;
import com.yicuojin.football.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ShareService implements IShareService {
    @Autowired
    private FootballShareMapper footballShareMapper;
    @Autowired
    private FootballBallParamMapper footballBallParamMapper;
    @Autowired
    private FootballAmountMapper footballAmountMapper;
    @Autowired
    private FootballAmountRecordMapper footballAmountRecordMapper;
    @Autowired
    private FootballUserMapper footballUserMapper;

    @Override
    public String addIntegral(Integer userId, Integer receiveId) {
        String shareResult = "";
        String receiveResult = "";
        int shareAccount = Integer.parseInt(footballBallParamMapper.selectByPrimaryKey(4).getValue());
        int receiveAccount = Integer.parseInt(footballBallParamMapper.selectByPrimaryKey(5).getValue());
        //判断用户今天助威次数是否大于限定次数
        FootballShareExample footballShareExampleReceive = new FootballShareExample();
        footballShareExampleReceive.createCriteria().andReciveidEqualTo(receiveId).andCreatetimeBetween(DateUtils.getStartTime(), DateUtils.getEndTime());
        int countByExampleReceive = footballShareMapper.countByExample(footballShareExampleReceive);
        boolean sameUser = true;
        if (userId == receiveId) {
            sameUser = false;
        }
        boolean isFirstReceive = true;
        List<FootballShare> footballShares = footballShareMapper.selectByExample(footballShareExampleReceive);
        for (FootballShare footballShare : footballShares) {
            if (footballShare.getUserid() == userId) {
                isFirstReceive = false;
            }
        }
        //判断分享的用户今天被助威次数是否大于限定次数
        FootballShareExample footballShareExampleUser = new FootballShareExample();
        footballShareExampleUser.createCriteria().andUseridEqualTo(userId).andCreatetimeBetween(DateUtils.getStartTime(), DateUtils.getEndTime());
        int countByExampleshare = footballShareMapper.countByExample(footballShareExampleUser);
        List<FootballShare> footballShareList = footballShareMapper.selectByExample(footballShareExampleUser);
        boolean isFirst = true;
        for (FootballShare footballShare : footballShareList) {
            if (footballShare.getReciveid() == receiveId) {
                isFirst = false;
            }
        }
        //如果小于，增加积分
        if (countByExampleReceive < receiveAccount && isFirstReceive && sameUser) {
            //修改用户余额
            FootballAmountExample footballAmountExampleReceive = new FootballAmountExample();
            footballAmountExampleReceive.createCriteria().andUseridEqualTo(receiveId);
            FootballAmount amountReceive = footballAmountMapper.selectByExample(footballAmountExampleReceive).get(0);

            FootballAmount footballAmount = new FootballAmount();
            footballAmount.setId(amountReceive.getId());
            footballAmount.setUserid(receiveId);
            footballAmount.setUpdatetime(new Date());
            footballAmount.setTotalamount(amountReceive.getTotalamount().add(
                    new BigDecimal(footballBallParamMapper.selectByPrimaryKey(7).getValue())));
            footballAmountMapper.updateByPrimaryKeySelective(footballAmount);
            //添加积分使用记录
            FootballAmountRecord footballAmountRecord = new FootballAmountRecord();
            footballAmountRecord.setAmount(new BigDecimal(footballBallParamMapper.selectByPrimaryKey(7).getValue()));
            footballAmountRecord.setCreatetime(new Date());
            footballAmountRecord.setUserid(receiveId);
            footballAmountRecord.setType(1);
            shareResult = "您给用户" + footballUserMapper.selectByPrimaryKey(userId).getNickname() + "增加了"
                    + footballBallParamMapper.selectByPrimaryKey(7).getValue() + "积分！";

        }

        //如果小于，增加积分
        if (countByExampleshare < shareAccount && isFirst && sameUser) {
            //修改用户余额
            FootballAmountExample footballAmountExample = new FootballAmountExample();
            footballAmountExample.createCriteria().andUseridEqualTo(userId);
            FootballAmount amount = footballAmountMapper.selectByExample(footballAmountExample).get(0);

            FootballAmount footballAmount = new FootballAmount();
            footballAmount.setId(amount.getId());
            footballAmount.setUserid(userId);
            footballAmount.setUpdatetime(new Date());
            footballAmount.setTotalamount(amount.getTotalamount().add(
                    new BigDecimal(footballBallParamMapper.selectByPrimaryKey(6).getValue())));
            footballAmountMapper.updateByPrimaryKeySelective(footballAmount);
            //添加积分使用记录
            FootballAmountRecord footballAmountRecord = new FootballAmountRecord();
            footballAmountRecord.setAmount(new BigDecimal(footballBallParamMapper.selectByPrimaryKey(6).getValue()));
            footballAmountRecord.setCreatetime(new Date());
            footballAmountRecord.setUserid(userId);
            footballAmountRecord.setType(1);
            receiveResult = "您增加了" + footballBallParamMapper.selectByPrimaryKey(6).getValue() + "积分 ！";
        }
        //添加分享记录
        if (sameUser && (isFirst || isFirstReceive)) {
            FootballShare footballShare = new FootballShare();
            footballShare.setCreatetime(new Date());
            footballShare.setReciveid(receiveId);
            footballShare.setUserid(userId);
            footballShareMapper.insertSelective(footballShare);
        } else {
            receiveResult = "今日次数已用完";
        }

        return receiveResult + shareResult;
    }
}
