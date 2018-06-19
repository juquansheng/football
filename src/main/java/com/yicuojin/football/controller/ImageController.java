package com.yicuojin.football.controller;

import com.yicuojin.football.service.IGroupService;
import com.yicuojin.football.service.IImageService;
import com.yicuojin.football.utils.YCJResult;
import com.yicuojin.football.vo.GroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    private IImageService iImageService;

    @RequestMapping(value = "geturl", method = RequestMethod.GET)
    @ResponseBody
    public YCJResult groupVoList(@RequestParam("id") Integer id) {
        String imageUrl = iImageService.getImageUrl(id);

        return YCJResult.build(200, "获取成功", imageUrl);
    }
}
