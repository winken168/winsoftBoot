package com.winsoft.core.tool;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLCode {

    /// <summary>
    /// 获取SQl脚本
    /// </summary>
    /// <param name="row"></param>
    /// <param name="keys"></param>
    /// <returns></returns>
    public static String GetSQLCommand(List<String> row, String... keys) {
        String where = "";
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("if not EXISTS (select 1 from  $s where ", "TableName"));
        for (String key : keys) {
            if (where != "") {
                where += " and ";
            }
            where += "[" + key + "]='" + "row[key].ToString()" + "'";
        }
        sb.append(where);
        sb.append(")\r\nbegin");//Insert

        sb.append(String.format(" insert into  $s (", "TableName"));//Insert
        String columns = "";
        for (String ct : row) {
            columns += "[" + "ct.ColumnName" + "],";
        }
        sb.append(columns.trim() + ") \r\n values(");
        columns = "";
        for (String ct : row) {
            if (1 == 1)//row["ct.ColumnName"].IsNull)
            {
                columns += "null,";
            } else {
                columns += "'" + "row[ct.ColumnName].ToString()" + "',";
            }
        }
        sb.append(columns.trim() + ")\r\n");
        sb.append(" end \r\n");
        sb.append(" else \r\n");
        sb.append(" begin \r\n");//Update
        sb.append(String.format("update $s set ", "row.TableName"));//Insert
        columns = "";
        List<String> items = new ArrayList();
        //items.addAll(keys);
        for (String ct : row) {
            if (items.contains("ct.ColumnName")) {
                continue;
            }
            if (1 == 1)//row[ct.ColumnName].IsNull)
            {
                columns += "[" + "ct.ColumnName" + "]=null,";
            } else {
                columns += "[" + "ct.ColumnName" + "]='" + "row[ct.ColumnName].ToString()" + "',";
            }
        }
        sb.append(columns.trim() + StrKit.format(" where $s ", where));
        sb.append(" end  ");
        return sb.toString();
    }


    /// <summary>
    /// 根据名称获取SQL（或视图）语句 （已经处理过注释，和参数替换的内容）
    /// </summary>
    /// <param name="key"></param>
    /// <param name="stringFormatValues">如果需要格式化大括号参数</param>
    /// <returns></returns>
    public static String GetCode(String key, String... stringFormatValues) {
        if (!StrKit.isNullOrEmpty(key)) {
            Hashtable<String, String> fileList = (Hashtable<String, String>) SearchFormat.dic_operte;
            if (fileList.containsKey(key)) {
                String text = fileList.get(key);
                if (text.contains(":\\")) {
                    //text = FileExtend.ReadAllText(text);
                    int index = text.lastIndexOf("/*");
                    if (index > -1)//去掉注释
                    {
                        text = text.replaceAll("/\\*(\\s|\\w|\\d)*\\*/", "");// Regex.replace(text, "/\*[.\s\S]*?\*/", string.Empty, RegexOptions.IgnoreCase);
                    }
                }
                text = text.trim();
                if (stringFormatValues.length > 0) {
                    text = String.format(text, stringFormatValues);
                }
                text = FormatPara(text.trim());//去掉空格
                if (key.charAt(0) == 'V' && text.charAt(0) != '(')//补充语法
                {
                    text = "(" + text + ") " + key;
                }

                //参数化格式
                return text;
            }
        }
        return key;
    }

    //
    public static String FormatPara(String sql) {
        //自动配置其它属性
        if (sql.indexOf('@') > -1) {
            String pattern = "\\(@.*?\\)";//"(@[\w^\u4e00-\u9fa5]+)";
            //MatchCollection mt = Regex.Matches(sql, pattern);
            Pattern p = Pattern.compile("\\(@.*?\\)");
            Matcher m = p.matcher(sql);
            ArrayList<String> parames = new ArrayList<String>();
            while (m.find()) {
                parames.add(m.group(0));
            }
            for (String key : parames) {
                if (!StrKit.isNullOrEmpty(key) && key.length() > 1) {
                    String item = key.replace("(@", "").replace(")", "");
                    String value = HttpKit.getRequestParameters().get(item);
                    if (!StrKit.isNullOrEmpty(value)) {
                        sql = sql.replace(item, value);
                    }
                }
            }
        }
        return sql.trim();//待写。
    }


}
