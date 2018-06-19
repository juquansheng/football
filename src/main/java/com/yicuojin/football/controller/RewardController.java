package com.yicuojin.football.controller;

import com.yicuojin.football.dao.FootballPlayerInfo;
import com.yicuojin.football.service.IPlayerService;
import com.yicuojin.football.utils.YCJResult;
import com.yicuojin.football.vo.PlayerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reward")
public class RewardController {
    @Autowired
    private IPlayerService playerService;
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult getMatch(@RequestParam("id") Integer id) {
        PlayerInfoVo infoById = playerService.getInfoById(id);
        if (infoById == null) {
            return YCJResult.build(500, "为获取到球员信息", null);
        } else {
            return YCJResult.build(200, "获取成功", infoById);
        }
    }
}
