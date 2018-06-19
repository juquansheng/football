package com.yicuojin.football.service.Impl;

import com.yicuojin.football.dao.FootballMessage;
import com.yicuojin.football.dao.FootballMessageExample;
import com.yicuojin.football.mapper.FootballMessageMapper;
import com.yicuojin.football.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class MessageService implements IMessageService {
    @Autowired
    private FootballMessageMapper footballMessageMapper;
    @Override
    public List<FootballMessage> getMessageByUserId(Integer userId) {
        FootballMessageExample footballMessageExample = new FootballMessageExample();
        footballMessageExample.createCriteria().andUseridEqualTo(userId).andStatusEqualTo(0);
        List<FootballMessage> footballMessages = footballMessageMapper.selectByExample(footballMessageExample);
        //修改消息状态未已推送
        for (FootballMessage footballMessage:footballMessages){
            footballMessage.setStatus(1);
            footballMessage.setUpdatetime(new Date());
            footballMessageMapper.updateByPrimaryKeySelective(footballMessage);
        }
        return footballMessages;
    }
}
