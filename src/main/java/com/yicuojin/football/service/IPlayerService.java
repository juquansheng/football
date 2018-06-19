package com.yicuojin.football.service;

import com.yicuojin.football.dao.FootballPlayerInfo;
import com.yicuojin.football.vo.PlayerInfoVo;

public interface IPlayerService {
    PlayerInfoVo getInfoById(Integer id);
}
