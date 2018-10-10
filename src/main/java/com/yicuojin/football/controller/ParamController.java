package com.yicuojin.football.controller;

import com.yicuojin.football.service.IParamService;
import com.yicuojin.football.utils.YCJResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/param")
public class ParamController {

    @Autowired
    private IParamService paramService;

    @RequestMapping(value = "/getParam", method = RequestMethod.GET)
    public YCJResult getParam(@RequestParam("id") Integer id) {
        String param = paramService.getParam(id);
        if (param != null) {
            return YCJResult.build(200, "获取参数成功", param);
        } else {
            return YCJResult.build(505, "参数不存在", null);
        }
    }
}
