package com.winsoft.core.db.dao;

import com.winsoft.core.db.core.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class BaseDao<T> implements IBaseDao<T> {

    @Autowired
    SqlMapper sqlMapper;

    @Override
    public Map<String, Object> selectOne(String sql) {
        return sqlMapper.selectOne(sql);
    }

    @Override
    public Map<String, Object> selectOne(String sql, Object value) {
        return sqlMapper.selectOne(sql,value);
    }

    @Override
    public <T1> T1 selectOne(String sql, Class<T1> resultType) {
        return sqlMapper.selectOne(sql,resultType);
    }

    @Override
    public <T1> T1 selectOne(String sql, Object value, Class<T1> resultType) {
        return sqlMapper.selectOne(sql,value,resultType);
    }

    @Override
    public List<Map<String, Object>> selectList(String sql) {
        return sqlMapper.selectList(sql);
    }

    @Override
    public List<Map<String, Object>> selectList(String sql, Object value) {
        return sqlMapper.selectList(sql, value);
    }

    @Override
    public <T1> List<T1> selectList(String sql, Class<T1> resultType) {
        return sqlMapper.selectList(sql,resultType);
    }

    @Override
    public <T1> List<T1> selectList(String sql, Object value, Class<T1> resultType) {
        return sqlMapper.selectList(sql,value,resultType);
    }

    @Override
    public int insert(String sql) {
        return sqlMapper.insert(sql);
    }

    @Override
    public int insert(String sql, Object value) {
        return sqlMapper.insert(sql,value);
    }

    @Override
    public int update(String sql) {
        return sqlMapper.update(sql);
    }

    @Override
    public int update(String sql, Object value) {
        return sqlMapper.update(sql,value);
    }

    @Override
    public int delete(String sql) {
        return sqlMapper.delete(sql);
    }

    @Override
    public int delete(String sql, Object value) {
        return sqlMapper.delete(sql,value);
    }
}
