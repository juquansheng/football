package com.yicuojin.football.service;


import com.yicuojin.football.dao.FootballMessage;

import java.util.List;

public interface IMessageService {
    List<FootballMessage> getMessageByUserId(Integer userId);
}
