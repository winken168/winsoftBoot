package com.winsoft.core.util;

import com.alibaba.fastjson.JSON;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.winsoft.core.enums.WinsoftExceptionEnum;
import com.winsoft.core.exception.WinsoftException;
/**
 * 渲染工具类
 *
 * @author fengshuonan
 * @date 2017-08-25 14:13
 */
public class RenderUtil {

    /**
     * 渲染json对象
     */
    public static void renderJson(HttpServletResponse response, Object jsonObject) {
        try {
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(jsonObject));
        } catch (IOException e) {
            throw new WinsoftException(WinsoftExceptionEnum.WRITE_ERROR);
        }
    }
}

