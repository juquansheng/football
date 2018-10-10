package com.yicuojin.football.service.Impl;

import com.yicuojin.football.dao.FootballAmount;
import com.yicuojin.football.dao.FootballAmountExample;
import com.yicuojin.football.dao.FootballUser;
import com.yicuojin.football.mapper.FootballAmountMapper;
import com.yicuojin.football.mapper.FootballUserMapper;
import com.yicuojin.football.service.IUserinfoService;
import com.yicuojin.football.utils.ListUtils;
import com.yicuojin.football.vo.UserinfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserinfoService implements IUserinfoService {
    @Autowired
    private FootballUserMapper footballUserMapper;
    @Autowired
    private FootballAmountMapper footballAmountMapper;

    @Override
    public UserinfoVo getInfo(Integer userid) {
        UserinfoVo userinfoVo = new UserinfoVo();
        FootballUser footballUser = footballUserMapper.selectByPrimaryKey(userid);
        FootballAmountExample footballAmountExample = new FootballAmountExample();
        footballAmountExample.createCriteria().andUseridEqualTo(userid);
        List<FootballAmount> footballAmounts = footballAmountMapper.selectByExample(footballAmountExample);
        if (!ListUtils.isEmpty(footballAmounts)) {
            userinfoVo.setAmount(footballAmounts.get(0).getTotalamount());
        }
        userinfoVo.setNickname(footballUser.getNickname());
        userinfoVo.setHeadimg(footballUser.getHeadimg());
        return userinfoVo;
    }
}
