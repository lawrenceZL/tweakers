package com.data.dao;

import com.data.model.Mylt;
import com.data.util.ResultData;

import java.sql.Timestamp;
import java.util.Map;

public interface MyltDao {

    ResultData query(Map<String, Object> condition);

    ResultData insert(Mylt mylt);

    ResultData update(Mylt mylt);

    ResultData delete(Timestamp createAt);
}
