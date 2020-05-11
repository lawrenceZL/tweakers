package com.data.dao.Impl;

import com.data.dao.BaseDao;
import com.data.dao.MyltDao;
import com.data.model.Mylt;
import com.data.model.Tweakers;
import com.data.util.ResponseCode;
import com.data.util.ResultData;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Repository
public class MyltDaoImpl extends BaseDao implements MyltDao {
    @Override
    public ResultData query(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<Tweakers> list = sqlSession.selectList("python.mylt.query", condition);
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
    public ResultData insert(Mylt mylt) {
        ResultData result = new ResultData();
        try {
            sqlSession.insert("python.mylt.insert", mylt);
            result.setData(mylt);
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData update(Mylt mylt) {
        ResultData result = new ResultData();
        try {
            sqlSession.update("python.mylt.update", mylt);
            result.setData(mylt);
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
            sqlSession.update("python.mylt.delete", createAt);
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }
}
