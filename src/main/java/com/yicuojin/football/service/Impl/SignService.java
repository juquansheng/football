package com.yicuojin.football.service.Impl;

import com.yicuojin.football.dao.FootballAmount;
import com.yicuojin.football.dao.FootballAmountExample;
import com.yicuojin.football.dao.FootballSign;
import com.yicuojin.football.dao.FootballSignExample;
import com.yicuojin.football.mapper.FootballAmountMapper;
import com.yicuojin.football.mapper.FootballBallParamMapper;
import com.yicuojin.football.mapper.FootballSignMapper;
import com.yicuojin.football.service.ISignService;
import com.yicuojin.football.utils.DateUtils;
import com.yicuojin.football.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class SignService implements ISignService {
    @Autowired
    private FootballSignMapper footballSignMapper;
    @Autowired
    private FootballBallParamMapper footballBallParamMapper;
    @Autowired
    private FootballAmountMapper footballAmountMapper;

    /**
     * 用户首次登陆送金币
     *
     * @param userId
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public boolean firstSign(Integer userId) {
        if (userId == 0) {
            return false;
        } else {
            //查询用户今天是不是首次登陆
            FootballSignExample footballSignExample = new FootballSignExample();
            footballSignExample.createCriteria().andDateBetween(DateUtils.getStartTime(), DateUtils.getEndTime()).andUseridEqualTo(userId);
            List<FootballSign> footballSigns = footballSignMapper.selectByExample(footballSignExample);

            if (ListUtils.isEmpty(footballSigns)) {
                //添加签到记录
                FootballSign footballSign = new FootballSign();
                footballSign.setUserid(userId);
                footballSign.setDate(new Date());
                footballSign.setReward(new BigDecimal(footballBallParamMapper.selectByPrimaryKey(3).getValue()));
                footballSignMapper.insertSelective(footballSign);
                //用户添加金币
                FootballAmountExample footballAmountExample = new FootballAmountExample();
                footballAmountExample.createCriteria().andUseridEqualTo(userId);
                List<FootballAmount> footballAmounts = footballAmountMapper.selectByExample(footballAmountExample);
                if (!ListUtils.isEmpty(footballAmounts)) {
                    FootballAmount footballAmount = footballAmounts.get(0);
                    BigDecimal totalamount = footballAmount.getTotalamount();
                    footballAmount.setUpdatetime(new Date());
                    footballAmount.setTotalamount(totalamount.add(new BigDecimal(footballBallParamMapper.selectByPrimaryKey(3).getValue())));
                    return footballAmountMapper.updateByPrimaryKeySelective(footballAmount) > 0;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
    }
}
