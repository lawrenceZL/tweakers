package com.data.service;

import com.data.model.Tweakers;
import com.data.util.ResultData;

import java.sql.Timestamp;
import java.util.Map;

public interface TweakersService {

    ResultData fetch(Map<String, Object> condition);

    ResultData create(Tweakers tweakers);

    ResultData modify(Tweakers tweakers);

    ResultData block(Timestamp createAt);
}
