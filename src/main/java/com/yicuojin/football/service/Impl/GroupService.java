package com.yicuojin.football.service.Impl;

import com.google.common.collect.Lists;
import com.yicuojin.football.dao.FootballGroup;
import com.yicuojin.football.dao.FootballGroupExample;
import com.yicuojin.football.dao.FootballTeamInfo;
import com.yicuojin.football.dao.FootballTeamInfoExample;
import com.yicuojin.football.mapper.FootballGroupMapper;
import com.yicuojin.football.mapper.FootballTeamInfoMapper;
import com.yicuojin.football.service.IGroupService;
import com.yicuojin.football.vo.GroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private FootballGroupMapper footballGroupMapper;
    @Autowired
    private FootballTeamInfoMapper footballTeamInfoMapper;
    @Override
    public List<GroupVo> getGroupVoList() {
        FootballGroupExample footballGroupExample = new FootballGroupExample();
        //获取所有列表
        List<FootballGroup> footballGroups = footballGroupMapper.selectByExample(footballGroupExample);
        List<GroupVo> groupVoList = Lists.newArrayList();
        //添加列表包含球队
        for (FootballGroup footballGroup:footballGroups){
            GroupVo groupVo = new GroupVo();
            FootballTeamInfoExample footballTeamInfoExample = new FootballTeamInfoExample();
            footballTeamInfoExample.createCriteria().andGroupidEqualTo(footballGroup.getId()).andStatusNotEqualTo(-1);
            List<FootballTeamInfo> teamInfoList = footballTeamInfoMapper.selectByExample(footballTeamInfoExample);
            groupVo.setFootballTeamInfoList(teamInfoList);
            groupVo.setGroupId(footballGroup.getId());
            groupVo.setGroupName(footballGroup.getName());
            groupVoList.add(groupVo);

        }
        return groupVoList;
    }
}
