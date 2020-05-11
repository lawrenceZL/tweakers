package com.data.dao.Impl;

import com.data.dao.BaseDao;
import com.data.dao.TweakersDao;
import com.data.model.Tweakers;
import com.data.util.ResponseCode;
import com.data.util.ResultData;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Repository
public class TweakersDaoImpl extends BaseDao implements TweakersDao {


    @Override
    public ResultData query(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<Tweakers> list = sqlSession.selectList("python.tweakers.query", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData insert(Tweakers tweakers) {
        ResultData result = new ResultData();
        try {
            sqlSession.insert("python.tweakers.insert", tweakers);
            result.setData(tweakers);
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData update(Tweakers tweakers) {
        ResultData result = new ResultData();
        try {
            sqlSession.update("python.tweakers.update", tweakers);
            result.setData(tweakers);
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData delete(Timestamp createAt) {
        ResultData result = new ResultData();
        try {
            sqlSession.update("python.tweakers.delete", createAt);
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }
}
