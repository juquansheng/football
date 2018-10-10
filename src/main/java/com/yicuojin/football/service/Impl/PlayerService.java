package com.yicuojin.football.service.Impl;

import com.google.common.collect.Lists;
import com.yicuojin.football.dao.FootballPlayerInfo;
import com.yicuojin.football.mapper.FootballPlayerInfoMapper;
import com.yicuojin.football.service.IPlayerService;
import com.yicuojin.football.vo.PlayerInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private FootballPlayerInfoMapper footballPlayerInfoMapper;

    @Override
    public PlayerInfoVo getInfoById(Integer id) {
        PlayerInfoVo playerInfoVo = new PlayerInfoVo();
        FootballPlayerInfo footballPlayerInfo = footballPlayerInfoMapper.selectByPrimaryKey(id);
        footballPlayerInfo.setImg("https://tjb.yunxinyong.net/football-0.0.1-SNAPSHOT/image/" + footballPlayerInfo.getImg() + ".png");
        footballPlayerInfo.setData("https://tjb.yunxinyong.net/football-0.0.1-SNAPSHOT/image/" + footballPlayerInfo.getData() + ".png");
        BeanUtils.copyProperties(footballPlayerInfo, playerInfoVo);
        String playerdescribe = footballPlayerInfo.getPlayerdescribe();
        String[] split = playerdescribe.split("、");
        List<String> b = Lists.newArrayList();
        b.addAll(Arrays.asList(split));
        playerInfoVo.setLabelList(b);
        return playerInfoVo;
    }
}
