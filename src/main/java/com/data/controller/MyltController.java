package com.data.controller;

import com.data.service.MyltService;
import com.data.util.ResultData;
import com.data.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@Component
@RequestMapping("/python/mylt")
public class MyltController {

    @Autowired
    private MyltService myltService;

    @GetMapping("/list")
    ResultData getListByTime(){
        ResultData result = new ResultData();
        Map<String,Object> condition = new HashMap<>();
        condition.put("blockFlag",false);
        condition.put("createDate",TimeUtil.getnhTime(3));
        result = myltService.fetch(condition);
        return result;
    }
}
