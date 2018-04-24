package com.winsoft.api.common.exception;

import com.winsoft.core.exception.WinsoftException;

/**
 * @author fengshuonan
 * @Description 业务异常的封装
 * @date 2016年11月12日 下午5:05:10
 */
public class BussinessException extends WinsoftException {

    public BussinessException(BizExceptionEnum bizExceptionEnum) {
        super(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(),"");
    }
}
