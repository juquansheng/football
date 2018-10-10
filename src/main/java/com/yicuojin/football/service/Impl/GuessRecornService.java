package com.yicuojin.football.service.Impl;

import com.google.common.collect.Lists;
import com.yicuojin.football.dao.FootballGuessRecord;
import com.yicuojin.football.dao.FootballGuessRecordExample;
import com.yicuojin.football.dao.FootballMatch;
import com.yicuojin.football.mapper.FootballGuessRecordMapper;
import com.yicuojin.football.mapper.FootballMatchMapper;
import com.yicuojin.football.mapper.FootballTeamInfoMapper;
import com.yicuojin.football.service.IGuessRecornService;
import com.yicuojin.football.vo.GuessRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class GuessRecornService implements IGuessRecornService {
    @Autowired
    private FootballGuessRecordMapper footballGuessRecordMapper;
    @Autowired
    private FootballMatchMapper footballMatchMapper;
    @Autowired
    private FootballTeamInfoMapper footballTeamInfoMapper;

    @Override
    public List<GuessRecordVo> getRecordList(Integer userId) {
        FootballGuessRecordExample footballGuessRecordExample = new FootballGuessRecordExample();
        footballGuessRecordExample.createCriteria().andUseridEqualTo(userId);
        footballGuessRecordExample.setOrderByClause("UpdateTime desc");
        List<FootballGuessRecord> footballGuessRecordList = footballGuessRecordMapper.selectByExample(footballGuessRecordExample);
        List<GuessRecordVo> guessRecordVoList = Lists.newArrayList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (FootballGuessRecord footballGuessRecord : footballGuessRecordList) {
            GuessRecordVo guessRecordVo = new GuessRecordVo();
            guessRecordVo.setCreatetime(format.format(footballGuessRecord.getCreatetime()));
            guessRecordVo.setUpdateTime(format.format(footballGuessRecord.getUpdatetime()));
            guessRecordVo.setId(footballGuessRecord.getId());
            guessRecordVo.setMatchid(footballGuessRecord.getMatchid());
            guessRecordVo.setUserid(footballGuessRecord.getUserid());
            guessRecordVo.setMatchresult(footballGuessRecord.getMatchresult());
            guessRecordVo.setStatus(footballGuessRecord.getStatus());
            guessRecordVo.setBets(footballGuessRecord.getBets());
            guessRecordVo.setReward(footballGuessRecord.getReward());
            guessRecordVo.setUserguess(footballGuessRecord.getUserguess());
            FootballMatch footballMatch = footballMatchMapper.selectByPrimaryKey(footballGuessRecord.getMatchid());
            guessRecordVo.setAname(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeama()).getName());
            guessRecordVo.setBname(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeamb()).getName());
            guessRecordVo.setAscore(footballMatch.getScorea());
            guessRecordVo.setBscore(footballMatch.getScoreb());
            guessRecordVo.setaFlag(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeama()).getImage());
            guessRecordVo.setbFlag(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeamb()).getImage());
            //用户猜测
            String userGuess = "";
            if (footballGuessRecord.getUserguess() == 1) {
                userGuess = "您猜" + footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeama()).getName() + "胜";
            } else if (footballGuessRecord.getUserguess() == 2) {
                userGuess = "您猜" + footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeamb()).getName() + "胜";
            } else if (footballGuessRecord.getUserguess() == 3) {
                userGuess = "您猜结果为平局";
            }
            /*//比赛结果
            String result = "";
            if (footballMatch.getResult() == 1){
                result = ""+footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeama()).getName() + "胜,";
            }else if(footballMatch.getResult() == 2){
                result = ""+footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeamb()).getName() + "胜,";
            }else if (footballMatch.getResult() == 3){
                result = "比赛结果为平局,";
            }*/
            String end = "";
            if (footballGuessRecord.getMatchresult() == 1) {
                end = ",获得" + footballGuessRecord.getReward() + "积分";
            } else if (footballGuessRecord.getMatchresult() == 2) {
                end = ",下次加油";
            }
            guessRecordVo.setDescribe(userGuess + end);
            guessRecordVoList.add(guessRecordVo);
        }

        return guessRecordVoList;
    }
}
