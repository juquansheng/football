package com.yicuojin.football.controller;

import com.yicuojin.football.service.IGroupService;
import com.yicuojin.football.utils.YCJResult;
import com.yicuojin.football.vo.GroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/group")
public class GroupController {
    @Autowired
    private IGroupService groupService;

    @RequestMapping(value = "/groupList", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult groupVoList(@RequestParam(value = "userId", required = false) Integer userId) {
        List<GroupVo> groupVoList = groupService.getGroupVoList();
        if (userId != null) {
            //添加进入咨询页面记录
        }
        return YCJResult.build(200, "获取成功", groupVoList);
    }
}
