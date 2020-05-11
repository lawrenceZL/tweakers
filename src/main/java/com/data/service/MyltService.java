package com.data.service;

import com.data.model.Tweakers;
import com.data.util.ResultData;

import java.sql.Timestamp;
import java.util.Map;

public interface MyltService {

    ResultData fetch(Map<String, Object> condition);

}
