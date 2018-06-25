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
    public YCJResult share(@RequestParam("shareId") Integer shareId,@RequestParam("receiveId") Integer receiveId) {
        if (shareId < 1){
            return YCJResult.build(500, "失败", "分享链接失败");
        }else {
            String integral = shareService.addIntegral(shareId, receiveId);
            return YCJResult.build(200, "成功", integral);
        }
    }
}
