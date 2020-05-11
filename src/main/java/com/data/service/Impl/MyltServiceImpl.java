package com.data.service.Impl;

import com.data.dao.BaseDao;
import com.data.dao.MyltDao;
import com.data.service.MyltService;
import com.data.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MyltServiceImpl extends BaseDao implements MyltService {

    @Autowired
    private MyltDao myltDao;

    @Override
    public ResultData fetch(Map<String, Object> condition) {
        return myltDao.query(condition);
    }
}
