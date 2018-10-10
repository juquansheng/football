package com.yicuojin.football.controller;

import com.yicuojin.football.dao.FootballMessage;
import com.yicuojin.football.mapper.FootballBallParamMapper;
import com.yicuojin.football.service.IMatchService;
import com.yicuojin.football.service.IMessageService;
import com.yicuojin.football.service.ISignService;
import com.yicuojin.football.service.IUserAmountService;
import com.yicuojin.football.utils.ListUtils;
import com.yicuojin.football.utils.YCJResult;
import com.yicuojin.football.vo.MatchInfoVo;
import com.yicuojin.football.vo.MatchResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/match")
public class MatchController {

    @Autowired
    private IMatchService matchService;
    @Autowired
    private ISignService signService;
    @Autowired
    private IMessageService messageService;
    @Autowired
    private FootballBallParamMapper footballBallParamMapper;
    @Autowired
    private IUserAmountService userAmountService;

    @RequestMapping(value = "/choice", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult choice(@RequestParam("userId") Integer userId, @RequestParam("matchId") Integer matchId,
                            @RequestParam("userGuess") Integer userGuess, @RequestParam(value = "bet", required = false) Integer bet) {

        boolean b = matchService.userChoice(userId, matchId, userGuess, new BigDecimal(bet));
        if (b) {
            return YCJResult.build(200, "下注成功", true);
        } else {
            return YCJResult.build(505, "下注失败", false);
        }
    }

    @RequestMapping(value = "/getMatch", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult getMatch(@RequestParam("userId") Integer userId) {

        MatchResponseVo matchResponseVo = new MatchResponseVo();
        List<MatchInfoVo> userMatchList = matchService.getUserMatchList1(userId);
        boolean firstSign = signService.firstSign(userId);
        List<FootballMessage> messageByUserId = messageService.getMessageByUserId(userId);
        matchResponseVo.setFirstSign(firstSign);
        matchResponseVo.setFootballMessageList(messageByUserId);
        matchResponseVo.setMatchInfoVoList(userMatchList);
        matchResponseVo.setSignCoin(Integer.parseInt(footballBallParamMapper.selectByPrimaryKey(3).getValue()));
        if (ListUtils.isEmpty(messageByUserId)) {
            matchResponseVo.setMessageNotNull(false);
        } else {
            matchResponseVo.setMessageNotNull(true);
        }
        matchResponseVo.setTotalAmount(userAmountService.getUserAmount(userId));
        return YCJResult.build(200, "成功", matchResponseVo);

    }

    @RequestMapping(value = "/setment", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult test() {

        matchService.Settlement1();
        return YCJResult.build(200, "成功", null);

    }
}
