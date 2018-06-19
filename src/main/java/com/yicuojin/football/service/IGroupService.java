package com.yicuojin.football.service;

import com.yicuojin.football.vo.GroupVo;

import java.util.List;

public interface IGroupService {
    /**
     * 获取分组列表信息
     * @return
     */
    List<GroupVo> getGroupVoList();
}
