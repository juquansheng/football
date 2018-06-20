package com.yicuojin.football.controller;


import com.yicuojin.football.service.IShareService;
import com.yicuojin.football.utils.YCJResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShareController {
    @Autowired
    private IShareService shareService;
    @RequestMapping(value = "share", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult share(@RequestParam("userId") Integer userId,@RequestParam("receiveId") Integer receiveId) {
        boolean integral = shareService.addIntegral(userId, receiveId);
        if (integral){
            return YCJResult.build(200, "成功", true);
        }else {
            return YCJResult.build(500, "失败", false);
        }
    }
}
