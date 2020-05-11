package com.data.dao;

import com.data.model.Tweakers;
import com.data.util.ResultData;

import java.sql.Timestamp;
import java.util.Map;

public interface TweakersDao {

    ResultData query(Map<String, Object> condition);

    ResultData insert(Tweakers tweakers);

    ResultData update(Tweakers tweakers);

    ResultData delete(Timestamp createAt);
}
