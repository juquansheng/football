package com.yicuojin.football.service;

import com.yicuojin.football.vo.RankVo;

import java.util.List;

public interface IRankService {
    int getUserRank(Integer userId);

    List<RankVo> getRankList(Integer userId);
}
