package com.yicuojin.football.controller;

import com.yicuojin.football.dao.FootballUser;
import com.yicuojin.football.service.IWxService;
import com.yicuojin.football.utils.YCJResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/wx")
public class WxController {
    @Autowired
    private IWxService wxService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult login(@RequestParam("code") String code, @RequestParam("rawData") String rawData,
                           @RequestParam("signature") String signature, @RequestParam("userInfo") String userInfo) {
        if (code == null || code.equals("")) {
            return YCJResult.build(500, "登陆失败", null);
        } else {
            FootballUser andSaveResultByCode = wxService.getAndSaveResultByCode(code);
            wxService.getAndSaveUserInfo(userInfo, andSaveResultByCode.getWeixinid());
            if (andSaveResultByCode.getWeixinid() == null) {
                return YCJResult.build(500, "登陆失败", null);
            } else {
                return YCJResult.build(200, "登陆成功", andSaveResultByCode.getWeixinid());
            }
        }
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult test() {
        return YCJResult.build(200, "test", null);
    }
}
