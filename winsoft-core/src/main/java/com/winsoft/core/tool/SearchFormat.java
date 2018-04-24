package com.winsoft.core.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/// <summary>
/// 搜索条件格式化。(从Json格式化成sql语句）
/// </summary>
public class SearchFormat {
    static Dictionary<String, String> dic_operte = new Hashtable<String, String>();

    public void SearchFormat() {
        dic_operte.put("like", "LIKE");
        dic_operte.put("between", "between");
        dic_operte.put("equal", "=");
        dic_operte.put("greater", ">");
        dic_operte.put("greaterequal", ">=");
        dic_operte.put("less", "<");
        dic_operte.put("lessEqual", "<=");
        dic_operte.put("in", "IN");
        dic_operte.put("datetimepoint", "");
        dic_operte.put("notequal", "<>");
        dic_operte.put("isnull", "is Null");
        dic_operte.put("and", "AND");
        dic_operte.put("or", "OR");
    }

    public String Format(String searchList, String appendWhere) {
        List<SearchItem> sos = JSON.parseObject(appendWhere, new TypeReference<ArrayList<SearchItem>>() {
        });//JsonHelper.ToList<SearchItem>(searchList);
        String sql = BuildSQL(sos, appendWhere);
        return sql;
    }

    private String BuildSQL(List<SearchItem> sos, String appendWhere) {
        StringBuffer sql = new StringBuffer(" 1=1 ");
        for (SearchItem obj : sos) {
            //处理简单查询
            if (obj.ParamOrAnd != null) {
                switch (obj.ParamPatten.toLowerCase()) {
                    case "in":
                    case "between":
                    case "greater":
                    case "greaterequal":
                    case "less":
                    case "lessEqual":
                    case "likeor":
                    case "isnull":
                        break;
                    case "like":
                        obj.ParamValue = "'%" + obj.ParamValue + "%'";
                        break;
                    default:
                        obj.ParamValue = "'" + obj.ParamValue + "'";
                        break;
                }
                if (obj.ParamPatten.toLowerCase() == "likeor") {
                    sql.append(String.format(" and (%s) ", obj.getParamName()));
                } else {
                    sql.append(String.format(" and {%s} {%s} {%s}", obj.getParamName(), GetOperate(obj.getParamPatten().toLowerCase()), obj.getParamName()));
                }

            } else {
                if (obj.ParamPatten.toLowerCase() == "like") {
                    sql.append(String.format(" {%s} {%s} {%s} '%{%s}%' ", obj.getParamOrAnd(), obj.getParamName(), GetOperate(obj.getParamPatten().toLowerCase()), obj.getParamValue()));
                } else if (obj.ParamPatten.toLowerCase() == "isnull") {
                    sql.append(String.format(" {%s} {%s} {%s} {%s} ", obj.getParamOrAnd(), obj.getParamName(), GetOperate(obj.getParamPatten().toLowerCase()), obj.getParamValue()));
                } else {
                    sql.append(String.format(" {%s} {%s} {%s} '{%s}'", obj.getParamOrAnd(), obj.getParamName(), GetOperate(obj.getParamPatten().toLowerCase()), obj.getParamValue()));
                }
            }
        }
        sql.append(appendWhere);
        return sql.toString();
    }

    private String GetOperate(String key) {
        if (dic_operte.get(key) != null) {
            return dic_operte.get(key);
        } else {
            return "=";
        }
    }


    public String Format(Object action, String searchList, String appendWhere) {
        List<SearchItem> sos = JSON.parseObject(appendWhere, new TypeReference<ArrayList<SearchItem>>() {
        });
        String sql = BuildSQL(action, sos, appendWhere);
        return sql;
    }

    private String BuildSQL(Object action, List<SearchItem> sos, String appendWhere) {
        StringBuilder sql = new StringBuilder(" 1=1 ");

        int index = 0;
        for (SearchItem obj : sos) {
            String param = "@Param" + (index++);

            // action.SetPara(param, obj.ParamValue, System.Data.DbType.String);
            //处理简单查询
            if (StrKit.isNullOrEmpty(obj.ParamOrAnd)) {
                if (obj.ParamPatten.toLowerCase() == "likeor") {
                    sql.append(String.format(" AND (%s) ", obj.getParamValue()));
                } else if (obj.ParamPatten.toLowerCase() == "like") {
                    sql.append(String.format(" AND $s $s '%'+$s+'%' ", obj.getParamName(), GetOperate(obj.getParamPatten().toLowerCase()), param));
                } else {
                    sql.append(String.format(" AND $s $s $s", obj.getParamName(), GetOperate(obj.getParamPatten().toLowerCase()), param));
                }
            } else {
                if (obj.ParamPatten.toLowerCase() == "like") {
                    sql.append(String.format(" $s $s $s '%'+$s+'%' ", obj.getParamOrAnd(), obj.getParamName(), GetOperate(obj.ParamPatten.toLowerCase()), param));
                } else if (obj.ParamPatten.toLowerCase() == "isnull") {
                    sql.append(String.format(" $s $s $s $s ", obj.getParamOrAnd(), obj.getParamName(), GetOperate(obj.getParamPatten().toLowerCase()), obj.getParamValue()));
                } else {
                    sql.append(String.format(" $s $s $s $s", obj.getParamOrAnd(), obj.getParamName(), GetOperate(obj.ParamPatten.toLowerCase()), param));
                }
            }
        }
        sql.append(appendWhere);
        return sql.toString();
    }


    private class SearchItem {

        /// <summary>
        ///
        /// </summary>
        private String ParamName;


        /// <summary>
        ///
        /// </summary>
        private String ParamValue;

        /// <summary>
        ///
        /// </summary>
        private String ParamPatten;

        /// <summary>
        ///
        /// </summary>
        private String ParamOrAnd;


        /// <summary>
        ///
        /// </summary>
        private String GroupName;

        public String getParamName() {
            return ParamName;
        }

        public void setParamName(String paramName) {
            ParamName = paramName;
        }

        public String getParamValue() {
            return ParamValue;
        }

        public void setParamValue(String paramValue) {
            ParamValue = paramValue;
        }

        public String getParamPatten() {
            return ParamPatten;
        }

        public void setParamPatten(String paramPatten) {
            ParamPatten = paramPatten;
        }

        public String getParamOrAnd() {
            return ParamOrAnd;
        }

        public void setParamOrAnd(String paramOrAnd) {
            ParamOrAnd = paramOrAnd;
        }

        public String getGroupName() {
            return GroupName;
        }

        public void setGroupName(String groupName) {
            GroupName = groupName;
        }


    }
}