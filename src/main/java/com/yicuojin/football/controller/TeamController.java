package com.yicuojin.football.controller;


import com.yicuojin.football.service.ITeamService;
import com.yicuojin.football.utils.YCJResult;
import com.yicuojin.football.vo.TeamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/team")
public class TeamController {
    @Autowired
    private ITeamService teamService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult teamVo(@RequestParam(value = "userId",required = false) Integer userId,@RequestParam("teamId") Integer teamId) {
        TeamVo teamVo = teamService.getTeamVo(teamId);
        if (userId != null){
            //添加查询球队信息页面记录
        }
        return YCJResult.build(200, "获取成功", teamVo);
    }
}
