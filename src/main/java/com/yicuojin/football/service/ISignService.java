package com.yicuojin.football.service;

public interface ISignService {
    /**
     * 用户首次登陆送金币
     *
     * @param userId
     * @return
     */
    boolean firstSign(Integer userId);
}
