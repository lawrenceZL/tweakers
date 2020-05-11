package com.data.service.Impl;

import com.data.dao.TweakersDao;
import com.data.model.Tweakers;
import com.data.service.TweakersService;
import com.data.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Map;

@Service
public class TweakersServiceImpl implements TweakersService {

    @Autowired
    private TweakersDao tweakersDao;

    @Override
    public ResultData fetch(Map<String, Object> condition) {
        return tweakersDao.query(condition);
    }

    @Override
    public ResultData create(Tweakers tweakers) {
        return tweakersDao.insert(tweakers);
    }

    @Override
    public ResultData modify(Tweakers tweakers) {
        return tweakersDao.update(tweakers);
    }

    @Override
    public ResultData block(Timestamp createAt) {
        return tweakersDao.delete(createAt);
    }
}
