package com.winsoft.core.exception;


import com.winsoft.core.enums.WinsoftExceptionEnum;

/**
 * @author winken
 * @Description 业务异常的封装
 * @date 2017年12月12日 下午5:05:10
 */
public class WinsoftException extends RuntimeException {

    //友好提示的code码
    protected int friendlyCode;

    //友好提示
    protected String friendlyMsg;

    //业务异常跳转的页面
    protected String urlPath;

    protected WinsoftException(int friendlyCode, String friendlyMsg, String urlPath) {
        this.setValues(friendlyCode, friendlyMsg, urlPath);
    }

    public  WinsoftException(WinsoftExceptionEnum bizExceptionEnum ,String msg){
        this.setValues(bizExceptionEnum.SQLMAPPER_ERROR.getCode(),msg,bizExceptionEnum.getUrlPath());
    }

    public WinsoftException(WinsoftExceptionEnum bizExceptionEnum) {
        this.setValues(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
    }

    private void setValues(int friendlyCode, String friendlyMsg, String urlPath) {
        this.friendlyCode = friendlyCode;
        this.friendlyMsg = friendlyMsg;
        this.urlPath = urlPath;
    }

    public int getCode() {
        return friendlyCode;
    }

    public void setCode(int code) {
        this.friendlyCode = code;
    }

    public String getMessage() {
        return friendlyMsg;
    }

    public void setMessage(String message) {
        this.friendlyMsg = message;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}

