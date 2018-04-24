package com.winsoft.api.modular.sys.controller;

import com.winsoft.api.common.exception.BizExceptionEnum;
import com.winsoft.api.common.exception.BussinessException;
import com.winsoft.api.modular.sys.dao.SysUserMapper;
import com.winsoft.api.modular.sys.model.SysUser;
import com.winsoft.core.base.controller.BaseController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

public class LoginController extends BaseController {

    @Autowired
    SysUserMapper um;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody SysUser login) throws BussinessException {

        String jwtToken = "";

        if (login.getAccount() == null || login.getPassword() == null) {
            throw new BussinessException(BizExceptionEnum.SIGN_ERROR);
        }

        String email = login.getEmail();
        String password = login.getPassword();

        SysUser user = um.selectOne(login);

        if (user == null) {
            throw new  BussinessException(BizExceptionEnum.SIGN_ERROR);
        }

        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new BussinessException(BizExceptionEnum.SIGN_ERROR);
        }

        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        return jwtToken;
    }

}
