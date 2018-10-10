package com.yicuojin.football.service.Impl;

import com.yicuojin.football.dao.FootballBallParam;
import com.yicuojin.football.mapper.FootballBallParamMapper;
import com.yicuojin.football.service.IParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParamService implements IParamService {
    @Autowired
    private FootballBallParamMapper footballBallParamMapper;

    @Override
    public String getParam(Integer id) {
        FootballBallParam footballBallParam = footballBallParamMapper.selectByPrimaryKey(id);
        if (footballBallParam != null && id > 2) {
            return footballBallParam.getValue();
        } else {
            return null;
        }
    }
}
