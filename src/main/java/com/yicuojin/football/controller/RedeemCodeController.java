package com.yicuojin.football.controller;

import com.yicuojin.football.dao.FootballRedeemCode;
import com.yicuojin.football.service.IRedeemCodeService;
import com.yicuojin.football.utils.YCJResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/redeem")
public class RedeemCodeController {
    @Autowired
    private IRedeemCodeService redeemCodeService;

    @RequestMapping(value = "/generator",method = RequestMethod.POST)
    public YCJResult generator(@RequestBody FootballRedeemCode footballRedeemCode){
        String generateRedeemCode = redeemCodeService.generateRedeemCode(footballRedeemCode.getUserid(),
                footballRedeemCode.getType(), footballRedeemCode.getAppaccount());
        if (generateRedeemCode != null){
            return YCJResult.build(200, "生成兑换码成功", generateRedeemCode);
        }else {
            return YCJResult.build(505, "生成兑换码失败", null);
        }
    }

    @RequestMapping(value = "/record",method = RequestMethod.GET)
    public YCJResult record(@RequestParam("userId") Integer userId){
        List<FootballRedeemCode> record = redeemCodeService.getRecord(userId);
        return YCJResult.build(200,"",record);
    }
}
