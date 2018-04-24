package com.winsoft.core.db.core;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ProcedureExec {

    public static List<Map<String, Object>> exec(SqlSession sqlSession,String procedureName, Object value){

        return   sqlSession.selectList("exec "+procedureName,value);
    }

}
