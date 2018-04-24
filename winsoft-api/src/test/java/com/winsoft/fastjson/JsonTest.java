package com.winsoft.fastjson;

import com.alibaba.fastjson.JSON;
import com.winsoft.api.modular.SimpleObject;
import com.winsoft.api.modular.auth.converter.BaseTransferEntity;
import com.winsoft.core.util.MD5Util;

public class JsonTest {
    public static void main(String[] args) {
        String randomKey = "1xm7hw";

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setUser("fsn");
        baseTransferEntity.setObject("123123");

        String json = JSON.toJSONString(simpleObject);

        SimpleObject dd= JSON.parseObject(json,SimpleObject.class);

        //md5签名
        String encrypt = MD5Util.encrypt(json + randomKey);
        baseTransferEntity.setSign(encrypt);

        System.out.println(JSON.toJSONString(baseTransferEntity));
    }
}
