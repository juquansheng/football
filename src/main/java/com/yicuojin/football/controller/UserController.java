package com.yicuojin.football.controller;

import com.yicuojin.football.service.IGuessRecornService;
import com.yicuojin.football.service.IRankService;
import com.yicuojin.football.service.IUserinfoService;
import com.yicuojin.football.utils.ListUtils;
import com.yicuojin.football.utils.YCJResult;
import com.yicuojin.football.vo.GuessRecordVo;
import com.yicuojin.football.vo.RankVo;
import com.yicuojin.football.vo.UserinfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IGuessRecornService guessRecornService;
    @Autowired
    private IRankService rankService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult getUserInfo(@RequestParam("userId") Integer userId) {
        UserinfoVo info = userinfoService.getInfo(userId);
        if (info == null) {
            return YCJResult.build(500, "获取失败", null);
        } else {
            return YCJResult.build(200, "获取成功", info);
        }
    }

    /**
     * 竞猜记录
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "record", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult getRecord(@RequestParam("userId") Integer userId) {
        List<GuessRecordVo> recordList = guessRecornService.getRecordList(userId);
        return YCJResult.build(200, "获取成功", recordList);
    }

    /**
     * 排行
     *
     * @return
     */
    @RequestMapping(value = "rank", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult getRank(@RequestParam("userId") Integer userId) {

        if (userId > 0) {
            List<RankVo> rankList = rankService.getRankList(userId);
            if (!ListUtils.isEmpty(rankList)) {
                return YCJResult.build(200, "获取成功", rankList);
            } else {
                return YCJResult.build(505, "获取失败", null);
            }

        } else {
            return YCJResult.build(505, "获取失败", null);
        }
    }
}
