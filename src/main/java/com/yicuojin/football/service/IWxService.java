package com.yicuojin.football.service;

import com.yicuojin.football.dao.FootballUser;

public interface IWxService {
    /**
     * 根据js_code获取并添加session_key 和 openid 等
     *
     * @param code
     * @return
     */
    FootballUser getAndSaveResultByCode(String code);

    /**
     * 获取并更新用户信息
     *
     * @param userInfo
     */
    void getAndSaveUserInfo(String userInfo, Integer weixinid);
}
