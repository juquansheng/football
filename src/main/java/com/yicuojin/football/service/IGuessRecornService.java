package com.yicuojin.football.service;

import com.yicuojin.football.vo.GuessRecordVo;

import java.util.List;

public interface IGuessRecornService {
    /**
     * 获取下注列表
     *
     * @param userId
     * @return
     */
    List<GuessRecordVo> getRecordList(Integer userId);
}
