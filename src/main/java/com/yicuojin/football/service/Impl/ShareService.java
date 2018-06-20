package com.yicuojin.football.service.Impl;

import com.yicuojin.football.dao.*;
import com.yicuojin.football.mapper.FootballAmountMapper;
import com.yicuojin.football.mapper.FootballAmountRecordMapper;
import com.yicuojin.football.mapper.FootballBallParamMapper;
import com.yicuojin.football.mapper.FootballShareMapper;
import com.yicuojin.football.service.IShareService;
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

    @Override
    public boolean addIntegral(Integer userId, Integer receiveId) {
        boolean result = false;
        int shareAccount = Integer.parseInt(footballBallParamMapper.selectByPrimaryKey(4).getValue());
        int receiveAccount = Integer.parseInt(footballBallParamMapper.selectByPrimaryKey(5).getValue());
        //判断用户今天助威次数是否大于限定次数
        FootballShareExample footballShareExampleReceive = new FootballShareExample();
        footballShareExampleReceive.createCriteria().andReciveidEqualTo(receiveId);
        int countByExampleReceive = footballShareMapper.countByExample(footballShareExampleReceive);
        boolean isFirstReceive = true;
        List<FootballShare> footballShares = footballShareMapper.selectByExample(footballShareExampleReceive);
        for (FootballShare footballShare:footballShares){
            if (footballShare.getUserid() == userId){
                isFirstReceive = false;
            }
        }
        //如果小于，增加积分
        if (countByExampleReceive < receiveAccount && isFirstReceive){
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
            result = footballAmountRecordMapper.insertSelective(footballAmountRecord)> 0;
        }
        //判断分享的用户今天被助威次数是否大于限定次数
        FootballShareExample footballShareExampleUser = new FootballShareExample();
        footballShareExampleUser.createCriteria().andUseridEqualTo(userId);
        int countByExampleshare = footballShareMapper.countByExample(footballShareExampleUser);
        List<FootballShare> footballShareList = footballShareMapper.selectByExample(footballShareExampleUser);
        boolean isFirst = true;
        for (FootballShare footballShare:footballShareList){
            if (footballShare.getReciveid() == receiveId){
                isFirst = false;
            }
        }
        //如果小于，增加积分
        if (countByExampleshare < shareAccount && isFirst){
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
            result = footballAmountRecordMapper.insertSelective(footballAmountRecord) > 0;
        }
        //添加分享记录
        if (isFirst || isFirstReceive){
            FootballShare footballShare = new FootballShare();
            footballShare.setCreatetime(new Date());
            footballShare.setReciveid(receiveId);
            footballShare.setUserid(userId);
            footballShareMapper.insertSelective(footballShare);
        }

        return result;
    }
}
