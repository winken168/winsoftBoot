package com.winsoft.api.modular.sys.controller;

import com.winsoft.api.modular.sys.dao.SysUserMapper;
import com.winsoft.core.base.controller.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    @RequestMapping("/list")
    public ResponseEntity hello(@RequestBody SysUserMapper user) {

       // return  user.selectList(user);

        return  null;
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return  null;
    }
}