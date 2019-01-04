package com.yicuojin.football.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yicuojin.football.dao.FootballAmount;
import com.yicuojin.football.dao.FootballUser;
import com.yicuojin.football.dao.FootballUserExample;
import com.yicuojin.football.mapper.FootballAmountMapper;
import com.yicuojin.football.mapper.FootballBallParamMapper;
import com.yicuojin.football.mapper.FootballUserMapper;
import com.yicuojin.football.service.IWxService;
import com.yicuojin.football.utils.ListUtils;
import com.yicuojin.football.utils.YCJHTTPUtils;
import com.yicuojin.football.vo.WxCodeResultVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WxService implements IWxService {

    @Autowired
    private FootballUserMapper footballUserMapper;
    @Autowired
    private FootballBallParamMapper footballBallParamMapper;
    @Autowired
    private FootballAmountMapper footballAmountMapper;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public FootballUser getAndSaveResultByCode(String code) {
        WxCodeResultVo wxCodeResultVo = new WxCodeResultVo();
        FootballUser footballUser = new FootballUser();
        try {
            if (code == null || code.equals("")) {
                // code 是空的！
                //logger.error("code 是空的");
                return null;
            } else {
                String APPID = footballBallParamMapper.selectByPrimaryKey(2).getValue();
                String SECRET = footballBallParamMapper.selectByPrimaryKey(1).getValue();
                // URL
                String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + SECRET + "&js_code=" + code
                        + "&grant_type=authorization_code";
                String codeResul = YCJHTTPUtils.getHttp(url, "utf-8");
                JSONObject jsonObj = JSON.parseObject(codeResul);
                if (jsonObj.getString("openid") == null) {
                    return footballUser;
                }
                FootballUserExample footballUserExampletest = new FootballUserExample();
                footballUserExampletest.createCriteria().andOpenidEqualTo(jsonObj.getString("openid"));
                List<FootballUser> footballUserstest = footballUserMapper.selectByExample(footballUserExampletest);
                //判断用户是否存在
                if (!ListUtils.isEmpty(footballUserstest)) {
                    footballUser.setWeixinid(footballUserstest.get(0).getWeixinid());
                } else {
                    if (jsonObj.getString("unionid") != null) {
                        wxCodeResultVo.setUnionid(jsonObj.getString("unionid"));
                        wxCodeResultVo.setOpenid(jsonObj.getString("openid"));
                        wxCodeResultVo.setSessionKey(jsonObj.getString("session_key"));
                        //添加数据
                        footballUser.setUnionid(jsonObj.getString("unionid"));
                        footballUser.setOpenid(jsonObj.getString("openid"));
                        footballUser.setSessionkey(jsonObj.getString("session_key"));
                        footballUser.setSource(1);
                        footballUser.setCreatetime(format.format(new Date()));

                        int i = footballUserMapper.insertSelective(footballUser);
                        FootballUserExample footballUserExample = new FootballUserExample();
                        footballUserExample.createCriteria().andOpenidEqualTo(footballUser.getOpenid());
                        List<FootballUser> footballUsers = footballUserMapper.selectByExample(footballUserExample);
                        if (!ListUtils.isEmpty(footballUsers)) {
                            footballUser.setWeixinid(footballUsers.get(0).getWeixinid());
                        }
                    } else if (jsonObj.getString("openid") == null) {

                        wxCodeResultVo.setOpenid(jsonObj.getString("openid"));
                        wxCodeResultVo.setSessionKey(jsonObj.getString("session_key"));
                        //添加数据
                        footballUser.setOpenid(jsonObj.getString("openid"));
                        footballUser.setSessionkey(jsonObj.getString("session_key"));
                        footballUser.setSource(1);
                        footballUser.setCreatetime(format.format(new Date()));

                        int i = footballUserMapper.insertSelective(footballUser);
                        FootballUserExample footballUserExample = new FootballUserExample();
                        footballUserExample.createCriteria().andOpenidEqualTo(footballUser.getOpenid());
                        List<FootballUser> footballUsers = footballUserMapper.selectByExample(footballUserExample);
                        if (!ListUtils.isEmpty(footballUsers)) {
                            footballUser.setWeixinid(footballUsers.get(0).getWeixinid());
                        }
                    } else {
                        wxCodeResultVo.setErrcode(jsonObj.getString("errcode"));
                        wxCodeResultVo.setErrmsg(jsonObj.getString("errmsg"));
                    }
                    //添加用户金币表
                    FootballAmount footballAmount = new FootballAmount();
                    footballAmount.setUserid(footballUser.getWeixinid());
                    footballAmount.setTotalamount(new BigDecimal(0.00));
                    footballAmount.setCreatetime(new Date());
                    footballAmount.setUpdatetime(new Date());
                    footballAmountMapper.insertSelective(footballAmount);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error(e);
        }
        return footballUser;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void getAndSaveUserInfo(String userInfo, Integer weixinid) {
        try {
            if (userInfo == null || userInfo == "") {
                // userInfo 是空的！
                //logger.error("userInfo 是空的");

            } else {
                JSONObject jsonObj = JSON.parseObject(userInfo);


                Object openid = jsonObj.getString("nickName");


                FootballUser footballUser = new FootballUser();
                footballUser.setWeixinid(weixinid);
                footballUser.setCity(jsonObj.getString("city"));
                footballUser.setNickname(jsonObj.getString("nickName"));
                footballUser.setCountry(jsonObj.getString("country"));
                footballUser.setHeadimg(jsonObj.getString("avatarUrl"));
                footballUser.setSex(jsonObj.getString("gender"));
                footballUser.setProvince(jsonObj.getString("province"));

                footballUserMapper.updateByPrimaryKeySelective(footballUser);
                jsonObj.getString("nickName");
                jsonObj.getString("avatarUrl");
                jsonObj.getString("gender");
                jsonObj.getString("city");
                jsonObj.getString("province");
                jsonObj.getString("country");
                jsonObj.getString("language");
                //更新用户信息
            }
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error(e);
        }

    }
}
