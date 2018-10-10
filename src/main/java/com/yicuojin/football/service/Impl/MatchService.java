package com.yicuojin.football.service.Impl;

import com.google.common.collect.Lists;
import com.yicuojin.football.Scheduling.MatchCmoponent;
import com.yicuojin.football.dao.*;
import com.yicuojin.football.mapper.*;
import com.yicuojin.football.service.IMatchService;
import com.yicuojin.football.utils.DateUtils;
import com.yicuojin.football.utils.ListUtils;
import com.yicuojin.football.vo.MatchInfoVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MatchService implements IMatchService {
    @Autowired
    private FootballMatchMapper footballMatchMapper;
    @Autowired
    private FootballGuessRecordMapper footballGuessRecordMapper;
    @Autowired
    private FootballTeamInfoMapper footballTeamInfoMapper;
    @Autowired
    private FootballMatchRewardMapper footballMatchRewardMapper;
    @Autowired
    private FootballAmountMapper footballAmountMapper;
    @Autowired
    private FootballMessageMapper footballMessageMapper;
    @Autowired
    private FootballAmountRecordMapper footballAmountRecordMapper;
    private Logger logger = Logger.getLogger(MatchService.class);

    @Override
    public List<MatchInfoVo> getUserMatchList(Integer userID) {
        FootballMatchExample footballMatchExample = new FootballMatchExample();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        footballMatchExample.createCriteria().andResultBetween(0, 0);
        List<FootballMatch> footballMatches = footballMatchMapper.selectByExample(footballMatchExample);
        List<MatchInfoVo> matchInfoVoList = Lists.newArrayList();
        for (FootballMatch footballMatch : footballMatches) {
            MatchInfoVo matchInfoVo = new MatchInfoVo();

            FootballGuessRecordExample guessRecordExampleA = new FootballGuessRecordExample();
            guessRecordExampleA.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(1);
            int A = footballGuessRecordMapper.countByExample(guessRecordExampleA);

            FootballGuessRecordExample guessRecordExampleB = new FootballGuessRecordExample();
            guessRecordExampleB.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(2);
            int B = footballGuessRecordMapper.countByExample(guessRecordExampleB);

            FootballGuessRecordExample guessRecordExampleAC = new FootballGuessRecordExample();
            guessRecordExampleAC.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(3);
            int C = footballGuessRecordMapper.countByExample(guessRecordExampleAC);

            matchInfoVo.setCountA(new BigDecimal(A));
            matchInfoVo.setCountB(new BigDecimal(B));
            matchInfoVo.setCountC(new BigDecimal(C));
            matchInfoVo.setId(footballMatch.getId());
            matchInfoVo.setAurl(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeama()).getImage());
            matchInfoVo.setBurl(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeamb()).getImage());
            matchInfoVo.setResult(footballMatch.getResult());
            matchInfoVo.setScorea(footballMatch.getScorea());
            matchInfoVo.setScoreb(footballMatch.getScoreb());
            matchInfoVo.setTeama(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeama()).getName());
            matchInfoVo.setTeamb(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeamb()).getName());
            matchInfoVo.setType(footballMatch.getType());
            matchInfoVo.setStarttime(format.format(footballMatch.getStarttime()));

            FootballGuessRecordExample footballGuessRecordExample = new FootballGuessRecordExample();
            footballGuessRecordExample.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUseridEqualTo(userID);
            List<FootballGuessRecord> footballGuessRecords = footballGuessRecordMapper.selectByExample(footballGuessRecordExample);
            if (!ListUtils.isEmpty(footballGuessRecords)) {
                matchInfoVo.setChoice(footballGuessRecords.get(0).getUserguess());
            } else {
                matchInfoVo.setChoice(0);
            }
            matchInfoVoList.add(matchInfoVo);
        }
        return matchInfoVoList;
    }


    /**
     * 结算（手动确定）
     *
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public boolean Settlement(Integer id) {
        FootballMatch footballMatch = footballMatchMapper.selectByPrimaryKey(id);
        if (footballMatch.getResult() == 1 || footballMatch.getResult() == 2 || footballMatch.getResult() == 3) {
            //查询所有下注金额
            FootballGuessRecordExample footballGuessRecordExample = new FootballGuessRecordExample();
            footballGuessRecordExample.createCriteria().andMatchidEqualTo(id);
            BigDecimal count = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExample);

            //判断是否有人竞猜
            if (count != null) {
                //查询猜对金额并添加奖励
                FootballGuessRecordExample footballGuessRecordExampleWin = new FootballGuessRecordExample();
                footballGuessRecordExampleWin.createCriteria().andMatchidEqualTo(id).andUserguessEqualTo(footballMatch.getResult());
                BigDecimal countWin = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExampleWin);
                System.out.println(countWin);
                //猜对每份奖励
                BigDecimal reward = count.divide(countWin, BigDecimal.ROUND_HALF_UP);
                List<FootballGuessRecord> footballGuessRecordList = footballGuessRecordMapper.selectByExample(footballGuessRecordExampleWin);
                List<FootballGuessRecord> footballGuessRecordListWin = footballGuessRecordMapper.selectByExample(footballGuessRecordExampleWin);
                //每条记录添加奖金和消息推送记录
                if (!ListUtils.isEmpty(footballGuessRecordListWin)) {
                    for (FootballGuessRecord footballGuessRecord : footballGuessRecordList) {
                        //查询用户金币表
                        FootballAmountExample footballAmountExample = new FootballAmountExample();
                        footballAmountExample.createCriteria().andUseridEqualTo(footballGuessRecord.getUserid());
                        List<FootballAmount> footballAmountList = footballAmountMapper.selectByExample(footballAmountExample);
                        if (!ListUtils.isEmpty(footballAmountList)) {
                            //更新用户金币表(根据每条记录)
                            FootballAmount footballAmount = footballAmountList.get(0);
                            BigDecimal totalamount = footballAmount.getTotalamount();
                            footballAmount.setTotalamount(totalamount.add(reward.multiply(footballGuessRecord.getBets())));
                            footballAmountMapper.updateByPrimaryKeySelective(footballAmount);
                        }
                        //添加用户推送消息记录
                        FootballMessage footballMessage = new FootballMessage();
                        footballMessage.setCreatetime(new Date());
                        footballMessage.setUpdatetime(new Date());
                        footballMessage.setUserid(footballGuessRecord.getUserid());
                        footballMessage.setContent("您竞猜的比赛id为" + footballGuessRecord.getMatchid() + "的比赛获得了" + reward.multiply(footballGuessRecord.getBets()) + "金币");
                        footballMessageMapper.insertSelective(footballMessage);
                        //更新用户竞猜记录表
                        footballGuessRecord.setMatchresult(1);
                        footballGuessRecord.setStatus(1);
                        footballGuessRecord.setUpdatetime(new Date());
                        footballGuessRecordMapper.updateByPrimaryKeySelective(footballGuessRecord);
                    }
                }
                FootballGuessRecordExample footballGuessRecordExampleOther = new FootballGuessRecordExample();
                footballGuessRecordExampleOther.createCriteria().andMatchidEqualTo(id).andUserguessNotEqualTo(footballMatch.getResult());
                List<FootballGuessRecord> footballGuessRecordListOther = footballGuessRecordMapper.selectByExample(footballGuessRecordExampleOther);
                if (!ListUtils.isEmpty(footballGuessRecordListOther)) {
                    for (FootballGuessRecord footballGuessRecord : footballGuessRecordListOther) {
                        //添加用户推送消息记录
                        FootballMessage footballMessage = new FootballMessage();
                        footballMessage.setCreatetime(new Date());
                        footballMessage.setUpdatetime(new Date());
                        footballMessage.setUserid(footballGuessRecord.getUserid());
                        footballMessage.setContent("您竞猜的比赛id为" + footballGuessRecord.getMatchid() + "的比赛未猜对");
                        footballMessageMapper.insertSelective(footballMessage);
                        //更新用户竞猜记录表
                        footballGuessRecord.setMatchresult(2);
                        footballGuessRecord.setStatus(1);
                        footballGuessRecord.setUpdatetime(new Date());
                        footballGuessRecordMapper.updateByPrimaryKeySelective(footballGuessRecord);
                    }
                }

                //查询猜A金额
                FootballGuessRecordExample footballGuessRecordExampleA = new FootballGuessRecordExample();
                footballGuessRecordExampleA.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(1);
                BigDecimal countA = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExampleA);
                //查询猜B金额
                FootballGuessRecordExample footballGuessRecordExampleB = new FootballGuessRecordExample();
                footballGuessRecordExampleB.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(2);
                BigDecimal countB = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExampleB);
                //查询猜C金额
                FootballGuessRecordExample footballGuessRecordExampleC = new FootballGuessRecordExample();
                footballGuessRecordExampleC.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(3);
                BigDecimal countC = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExampleC);


                //添加比赛经历记录表
                FootballMatchReward footballMatchReward = new FootballMatchReward();
                footballMatchReward.setAacount(countA);
                footballMatchReward.setBacount(countB);
                footballMatchReward.setCacount(countC);
                footballMatchReward.setMatchid(footballMatch.getId());
                footballMatchReward.setReward(reward);
                footballMatchRewardMapper.insertSelective(footballMatchReward);

                //修改比赛状态已开奖
                FootballMatch footballMatchUpdate = new FootballMatch();
                footballMatchUpdate.setId(footballMatch.getId());
                footballMatchUpdate.setResult(5);
                return footballMatchMapper.updateByPrimaryKeySelective(footballMatchUpdate) > 0;
            } else {
                //查询猜A金额
                FootballGuessRecordExample footballGuessRecordExampleA = new FootballGuessRecordExample();
                footballGuessRecordExampleA.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(1);
                BigDecimal countA = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExampleA);
                //查询猜B金额
                FootballGuessRecordExample footballGuessRecordExampleB = new FootballGuessRecordExample();
                footballGuessRecordExampleB.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(2);
                BigDecimal countB = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExampleB);
                //查询猜C金额
                FootballGuessRecordExample footballGuessRecordExampleC = new FootballGuessRecordExample();
                footballGuessRecordExampleC.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(3);
                BigDecimal countC = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExampleC);


                //添加比赛经历记录表
                FootballMatchReward footballMatchReward = new FootballMatchReward();
                footballMatchReward.setAacount(countA);
                footballMatchReward.setBacount(countB);
                footballMatchReward.setCacount(countC);
                footballMatchReward.setMatchid(footballMatch.getId());
                footballMatchReward.setReward(new BigDecimal(0));
                footballMatchRewardMapper.insertSelective(footballMatchReward);
                //修改比赛状态已开奖
                FootballMatch footballMatchUpdate = new FootballMatch();
                footballMatchUpdate.setId(footballMatch.getId());
                footballMatchUpdate.setResult(5);
                footballMatchMapper.updateByPrimaryKeySelective(footballMatchUpdate);
                return false;
            }
        } else {
            return false;
        }

    }


    /**
     * 每五分钟修改一次比赛状态（根据比赛是否开始，比赛开始竞猜结束）
     */
    @Override
    public boolean matechResult() {
        try {
            boolean result = false;
            //查询所有竞猜状态为0的
            FootballMatchExample footballMatchExample = new FootballMatchExample();
            footballMatchExample.createCriteria().andResultEqualTo(0);
            List<FootballMatch> footballMatches = footballMatchMapper.selectByExample(footballMatchExample);
            Date now = new Date();
            if (!ListUtils.isEmpty(footballMatches)) {
                for (FootballMatch footballMatch : footballMatches) {
                    //判断比赛是否开始,如果开始修改比赛状态为4
                    Date starttime = footballMatch.getStarttime();
                    if (now.getTime() > starttime.getTime()) {
                        result = true;
                        footballMatch.setResult(4);
                        footballMatch.setCreatetime(null);
                        int i = footballMatchMapper.updateByPrimaryKeySelective(footballMatch);
                        if (i == 0) {
                            logger.info("修改" + footballMatch.getId() + "比赛状态失败");
                        }
                    }
                }
            }
            return result;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * 返回用户竞猜页列表(用户选择下注)
     *
     * @param userID
     * @return
     */
    @Override
    public List<MatchInfoVo> getUserMatchList1(Integer userID) {
        FootballMatchExample footballMatchExample = new FootballMatchExample();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        footballMatchExample.createCriteria().andResultBetween(0, 4).andStarttimeGreaterThanOrEqualTo(DateUtils.getYestodayStartTime());
        footballMatchExample.setOrderByClause("StartTime asc");
        List<FootballMatch> footballMatches = footballMatchMapper.selectByExample(footballMatchExample);
        List<MatchInfoVo> matchInfoVoList = Lists.newArrayList();
        for (FootballMatch footballMatch : footballMatches) {
            MatchInfoVo matchInfoVo = new MatchInfoVo();

            FootballGuessRecordExample guessRecordExampleA = new FootballGuessRecordExample();
            guessRecordExampleA.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(1);
            BigDecimal A = footballGuessRecordMapper.countBetsByExample(guessRecordExampleA);

            FootballGuessRecordExample guessRecordExampleB = new FootballGuessRecordExample();
            guessRecordExampleB.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(2);
            BigDecimal B = footballGuessRecordMapper.countBetsByExample(guessRecordExampleB);

            FootballGuessRecordExample guessRecordExampleAC = new FootballGuessRecordExample();
            guessRecordExampleAC.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(3);
            BigDecimal C = footballGuessRecordMapper.countBetsByExample(guessRecordExampleAC);

            if (A == null) {
                matchInfoVo.setCountA(new BigDecimal(0));
            } else {
                matchInfoVo.setCountA(A);
            }
            if (B == null) {
                matchInfoVo.setCountB(new BigDecimal(0));
            } else {
                matchInfoVo.setCountB(B);
            }
            if (C == null) {
                matchInfoVo.setCountC(new BigDecimal(0));
            } else {
                matchInfoVo.setCountC(C);
            }


            matchInfoVo.setId(footballMatch.getId());
            matchInfoVo.setAurl(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeama()).getImage());
            matchInfoVo.setBurl(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeamb()).getImage());
            matchInfoVo.setResult(footballMatch.getResult());
            matchInfoVo.setScorea(footballMatch.getScorea());
            matchInfoVo.setScoreb(footballMatch.getScoreb());
            matchInfoVo.setTeama(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeama()).getName());
            matchInfoVo.setTeamb(footballTeamInfoMapper.selectByPrimaryKey(footballMatch.getTeamb()).getName());
            matchInfoVo.setIdA(footballMatch.getTeama());
            matchInfoVo.setIdB(footballMatch.getTeamb());
            matchInfoVo.setType(footballMatch.getType());
            matchInfoVo.setStarttime(format.format(footballMatch.getStarttime()));
            matchInfoVo.setArate(footballMatch.getArate());
            matchInfoVo.setBrate(footballMatch.getBrate());
            matchInfoVo.setPrate(footballMatch.getPrate());

            FootballGuessRecordExample footballGuessRecordExample = new FootballGuessRecordExample();
            footballGuessRecordExample.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUseridEqualTo(userID);
            List<FootballGuessRecord> footballGuessRecords = footballGuessRecordMapper.selectByExample(footballGuessRecordExample);
            if (!ListUtils.isEmpty(footballGuessRecords)) {
                matchInfoVo.setChoice(footballGuessRecords.get(0).getUserguess());
            } else {
                matchInfoVo.setChoice(0);
            }
            matchInfoVoList.add(matchInfoVo);
        }
        return matchInfoVoList;
    }

    /**
     * 用户下注(用户选择下注)
     */
    @Override
    public boolean userChoice(Integer userId, Integer matchId, Integer userGuess, BigDecimal bet) {
        //判断比赛是否可下注
        Integer result = footballMatchMapper.selectByPrimaryKey(matchId).getResult();
        if (result != 0 || bet == null) {
            return false;
        } else {
            //判断用户余额是否足够下单
            FootballAmountExample footballAmountExample = new FootballAmountExample();
            footballAmountExample.createCriteria().andUseridEqualTo(userId);
            List<FootballAmount> footballAmounts = footballAmountMapper.selectByExample(footballAmountExample);
            if (!ListUtils.isEmpty(footballAmounts)) {
                BigDecimal totalAmount = footballAmounts.get(0).getTotalamount();
                if (totalAmount.compareTo(bet) > -1 && bet.compareTo(new BigDecimal(0)) > -1) {
                    //修改用户余额
                    FootballAmount footballAmount = new FootballAmount();
                    footballAmount.setId(footballAmounts.get(0).getId());
                    footballAmount.setUserid(userId);
                    footballAmount.setUpdatetime(new Date());
                    footballAmount.setTotalamount(totalAmount.subtract(bet));
                    footballAmountMapper.updateByPrimaryKeySelective(footballAmount);
                    //添加积分使用记录
                    FootballAmountRecord footballAmountRecord = new FootballAmountRecord();
                    footballAmountRecord.setAmount(bet);
                    footballAmountRecord.setCreatetime(new Date());
                    footballAmountRecord.setUserid(userId);
                    footballAmountRecord.setType(1);
                    footballAmountRecord.setStatus(1);
                    footballAmountRecordMapper.insertSelective(footballAmountRecord);
                    //添加用户下注记录
                    FootballGuessRecord footballGuessRecord = new FootballGuessRecord();
                    footballGuessRecord.setCreatetime(new Date());
                    footballGuessRecord.setUpdatetime(new Date());
                    footballGuessRecord.setMatchid(matchId);
                    footballGuessRecord.setUserid(userId);
                    footballGuessRecord.setBets(bet);
                    footballGuessRecord.setUserguess(userGuess);
                    footballGuessRecord.setStatus(0);
                    return footballGuessRecordMapper.insertSelective(footballGuessRecord) > 0;
                }
                return false;
            } else {
                return false;
            }
        }
    }

    /**
     * 结算(自动结算)
     *
     * @return
     */
    @Override
    public void Settlement1() {
        //查询所有需要结算的比赛
        FootballMatchExample footballMatchExample = new FootballMatchExample();
        footballMatchExample.createCriteria().andResultBetween(1, 3);
        List<FootballMatch> footballMatches = footballMatchMapper.selectByExample(footballMatchExample);
        //结算
        for (FootballMatch footballMatch : footballMatches) {
            //查询所有下注人数金额
            FootballGuessRecordExample footballGuessRecordExample = new FootballGuessRecordExample();
            footballGuessRecordExample.createCriteria().andMatchidEqualTo(footballMatch.getId());
            BigDecimal count = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExample);
            //查询猜对金额并添加奖励

            FootballGuessRecordExample footballGuessRecordExample1 = new FootballGuessRecordExample();
            footballGuessRecordExample1.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(footballMatch.getResult());
            BigDecimal countWin = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExample1);
            System.out.println(countWin);
            if (countWin != null) {
                //猜对每份奖励
                BigDecimal reward = count.divide(countWin, BigDecimal.ROUND_HALF_UP);
                List<FootballGuessRecord> footballGuessRecordList = footballGuessRecordMapper.selectByExample(footballGuessRecordExample);
                //每条记录添加奖金
                for (FootballGuessRecord footballGuessRecord : footballGuessRecordList) {
                    //查询用户金币表
                    FootballAmountExample footballAmountExample = new FootballAmountExample();
                    footballAmountExample.createCriteria().andUseridEqualTo(footballGuessRecord.getUserid());
                    List<FootballAmount> footballAmountList = footballAmountMapper.selectByExample(footballAmountExample);
                    if (!ListUtils.isEmpty(footballAmountList)) {
                        //更新用户金币表(根据每条记录)
                        FootballAmount footballAmount = footballAmountList.get(0);
                        BigDecimal totalamount = footballAmount.getTotalamount();
                        footballAmount.setTotalamount(totalamount.add(reward).multiply(footballGuessRecord.getBets()));
                        footballAmountMapper.updateByPrimaryKeySelective(footballAmount);
                    }
                    //更新用户竞猜记录表
                    footballGuessRecord.setMatchresult(1);
                    footballGuessRecord.setStatus(1);
                    footballGuessRecordMapper.updateByPrimaryKeySelective(footballGuessRecord);
                }

                //查询猜A金额
                FootballGuessRecordExample footballGuessRecordExampleA = new FootballGuessRecordExample();
                footballGuessRecordExampleA.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(1);
                BigDecimal countA = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExampleA);
                //查询猜B金额
                FootballGuessRecordExample footballGuessRecordExampleB = new FootballGuessRecordExample();
                footballGuessRecordExampleB.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(2);
                BigDecimal countB = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExampleB);
                //查询猜C金额
                FootballGuessRecordExample footballGuessRecordExampleC = new FootballGuessRecordExample();
                footballGuessRecordExampleC.createCriteria().andMatchidEqualTo(footballMatch.getId()).andUserguessEqualTo(3);
                BigDecimal countC = footballGuessRecordMapper.countBetsByExample(footballGuessRecordExampleC);


                //添加比赛经历记录表
                FootballMatchReward footballMatchReward = new FootballMatchReward();
                footballMatchReward.setAacount(countA);
                footballMatchReward.setBacount(countB);
                footballMatchReward.setCacount(countC);
                footballMatchReward.setMatchid(footballMatch.getId());
                footballMatchReward.setReward(reward);
                footballMatchRewardMapper.insertSelective(footballMatchReward);

                //修改比赛状态已开奖
                FootballMatch footballMatchUpdate = new FootballMatch();
                footballMatchUpdate.setResult(5);
                footballMatchMapper.updateByPrimaryKeySelective(footballMatchUpdate);
            } else {
                //修改比赛状态已开奖
                FootballMatch footballMatchUpdate = new FootballMatch();
                footballMatchUpdate.setId(footballMatch.getId());
                footballMatchUpdate.setResult(5);
                footballMatchMapper.updateByPrimaryKeySelective(footballMatchUpdate);

            }

        }
    }
}
