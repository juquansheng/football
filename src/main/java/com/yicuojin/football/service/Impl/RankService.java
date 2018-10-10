package com.yicuojin.football.service.Impl;

import com.google.common.collect.Lists;
import com.yicuojin.football.dao.FootballAmount;
import com.yicuojin.football.dao.FootballAmountExample;
import com.yicuojin.football.mapper.FootballAmountMapper;
import com.yicuojin.football.mapper.FootballUserMapper;
import com.yicuojin.football.service.IRankService;
import com.yicuojin.football.vo.RankVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService implements IRankService {
    @Autowired
    private FootballAmountMapper footballAmountMapper;
    @Autowired
    private FootballUserMapper footballUserMapper;

    @Override
    public int getUserRank(Integer userId) {
        FootballAmountExample footballAmountExample = new FootballAmountExample();
        FootballAmountExample footballAmountExampleMe = new FootballAmountExample();
        footballAmountExampleMe.createCriteria().andUseridEqualTo(userId);
        footballAmountExample.createCriteria().andTotalamountGreaterThan(footballAmountMapper.selectByExample(footballAmountExampleMe).get(0).getTotalamount());
        int rank = footballAmountMapper.countByExample(footballAmountExample);
        return rank + 1;
    }

    @Override
    public List<RankVo> getRankList(Integer userId) {
        List<RankVo> rankVoList = Lists.newArrayList();
        List<FootballAmount> footballAmountList = footballAmountMapper.selectRank();
        for (int i = 0; i < footballAmountList.size(); i++) {
            RankVo rankVo = new RankVo();
            FootballAmount footballAmount = footballAmountList.get(i);
            rankVo.setAmount(footballAmount.getTotalamount());
            rankVo.setRank(i + 1);
            rankVo.setUserId(footballAmount.getUserid());
            rankVo.setHead(footballUserMapper.selectByPrimaryKey(footballAmount.getUserid()).getHeadimg());
            if (footballAmount.getUserid() == userId) {
                rankVo.setIsMe(1);
                rankVo.setName("我");
            } else {
                rankVo.setIsMe(0);
                rankVo.setName(footballUserMapper.selectByPrimaryKey(footballAmount.getUserid()).getNickname());
            }
            rankVoList.add(rankVo);
        }
        if (!this.isInList(rankVoList, userId)) {
            RankVo rankVoMe = new RankVo();
            rankVoMe.setName("我");
            rankVoMe.setIsMe(1);
            rankVoMe.setHead(footballUserMapper.selectByPrimaryKey(userId).getHeadimg());
            rankVoMe.setRank(this.getUserRank(userId));
            rankVoMe.setUserId(userId);
            FootballAmountExample footballAmountExample = new FootballAmountExample();
            footballAmountExample.createCriteria().andUseridEqualTo(userId);
            rankVoMe.setAmount(footballAmountMapper.selectByExample(footballAmountExample).get(0).getTotalamount());
            rankVoList.add(rankVoMe);
        }
        return rankVoList;
    }

    private boolean isInList(List<RankVo> rankVos, Integer userId) {
        boolean isInList = false;
        for (RankVo rankVo : rankVos) {
            if (rankVo.getUserId() == userId) {
                isInList = true;
                break;
            }
        }
        return isInList;
    }
}
