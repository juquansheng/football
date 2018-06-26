package com.yicuojin.football.controller;

import com.yicuojin.football.dao.FootballRedeemCode;
import com.yicuojin.football.dao.FootballRedeemGoods;
import com.yicuojin.football.dao.FootballRedeemItem;
import com.yicuojin.football.service.IRedeemService;
import com.yicuojin.football.utils.ListUtils;
import com.yicuojin.football.utils.YCJResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/redeem")
public class RedeemCodeController {
    @Autowired
    private IRedeemService redeemService;

    @RequestMapping(value = "/generator",method = RequestMethod.POST)
    public YCJResult generator(@RequestBody FootballRedeemCode footballRedeemCode){
        String generateRedeemCode = redeemService.generateRedeemCode(footballRedeemCode.getUserid(),
                footballRedeemCode.getRedeemgoodsid(), footballRedeemCode.getAppaccount());
        if (generateRedeemCode != null){
            return YCJResult.build(200, "生成兑换码成功", generateRedeemCode);
        }else {
            return YCJResult.build(505, "生成兑换码失败", null);
        }
    }

    @RequestMapping(value = "/record",method = RequestMethod.GET)
    public YCJResult record(@RequestParam("userId") Integer userId){
        List<FootballRedeemCode> record = redeemService.getRecord(userId);
        return YCJResult.build(200,"",record);
    }

    @RequestMapping(value = "/item",method = RequestMethod.GET)
    public YCJResult item(){
        List<FootballRedeemItem> redeemList = redeemService.getRedeemList();
        if (!ListUtils.isEmpty(redeemList)){
            return YCJResult.build(200,"",redeemList);
        }else {
            return YCJResult.build(500,"",null);
        }

    }

    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    public YCJResult goodsByItemId(@RequestParam("itemId") Integer itemId){
        List<FootballRedeemGoods> goodsByItemId = redeemService.getGoodsByItemId(itemId);
        if (!ListUtils.isEmpty(goodsByItemId)){
            return YCJResult.build(200,"",goodsByItemId);
        }else {
            return YCJResult.build(500,"",null);
        }
    }
}
