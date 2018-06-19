package com.yicuojin.football.service.Impl;

import com.yicuojin.football.dao.FootballAmount;
import com.yicuojin.football.dao.FootballAmountExample;
import com.yicuojin.football.mapper.FootballAmountMapper;
import com.yicuojin.football.service.IUserAmountService;
import com.yicuojin.football.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserAmountService implements IUserAmountService {
    @Autowired
    private FootballAmountMapper footballAmountMapper;
    @Override
    public BigDecimal getUserAmount(Integer userId) {
        FootballAmountExample footballAmountExample = new FootballAmountExample();
        footballAmountExample.createCriteria().andUseridEqualTo(userId);
        List<FootballAmount> footballAmounts = footballAmountMapper.selectByExample(footballAmountExample);
        if (!ListUtils.isEmpty(footballAmounts)){
            return footballAmounts.get(0).getTotalamount();
        }else {
            return new BigDecimal(0.00);
        }

    }
}
