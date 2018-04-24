package com.winsoft.jwt;

import com.alibaba.fastjson.JSON;
import com.winsoft.api.modular.SimpleObject;
import com.winsoft.api.modular.auth.converter.BaseTransferEntity;
import com.winsoft.api.modular.auth.security.impl.Base64SecurityAction;
import com.winsoft.core.util.MD5Util;

public class DecryptTest {

    public static void main(String[] args) {

        String key = "mySecret";

        String compactJws = "eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiI4Y3UwY2UiLCJzdWIiOiJhZG1pbiIsImV4cCI6MTUxNDc5MzE4NSwiaWF0IjoxNTE0MTg4Mzg1fQ.sqU7-tnAXcrmRj1lN1DonrSuYR6gBhpGO_fVdqU6VbBBvu1b1W4CQXFeEAWfxOb0yPYykBLSEdFFIEz3ImhCQQ";
        String salt = "8cu0ce";

        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setUser("stylefeng");
        simpleObject.setAge(12);
        simpleObject.setName("ffff");
        simpleObject.setTips("code");

        String jsonString = JSON.toJSONString(simpleObject);
        String encode = new Base64SecurityAction().doAction(jsonString);
        String md5 = MD5Util.encrypt(encode + salt);

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        baseTransferEntity.setObject(encode);
        baseTransferEntity.setSign(md5);

        System.out.println(JSON.toJSONString(baseTransferEntity));

        //System.out.println("body = " + Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody());
        //System.out.println("header = " + Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getHeader());
        //System.out.println("signature = " + Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getSignature());
    }
}
