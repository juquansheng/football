package com.yicuojin.football.service.Impl;

import com.yicuojin.football.mapper.FootballImageMapper;
import com.yicuojin.football.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImageService implements IImageService {
    @Autowired
    private FootballImageMapper footballImageMapper;

    @Override
    public String getImageUrl(Integer id) {
        return footballImageMapper.selectByPrimaryKey(id).getUrl();

    }
}
