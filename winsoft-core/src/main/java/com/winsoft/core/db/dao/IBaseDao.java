package com.winsoft.core.db.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao<T>  {

    Map<String,Object> selectOne(String sql);

    Map<String,Object> selectOne(String sql, Object value);

    <T> T selectOne(String sql, Class<T> resultType);

    <T> T selectOne(String sql, Object value, Class<T> resultType);

    List<Map<String,Object>> selectList(String sql);

    List<Map<String,Object>> selectList(String sql, Object value);

    <T> List<T> selectList(String sql, Class<T> resultType);

    <T> List<T> selectList(String sql, Object value, Class<T> resultType);

    int insert(String sql);

    int insert(String sql, Object value);

    int update(String sql);

    int update(String sql, Object value);

    int delete(String sql);

    int delete(String sql, Object value);
}
