package com.winsoft.api.modular.example;

import com.winsoft.api.common.SimpleObject;
import com.winsoft.api.modular.sys.model.SysUser;
import com.winsoft.core.base.controller.BaseController;
import com.winsoft.core.db.core.SqlMapper;
import com.winsoft.core.tool.HttpKit;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 常规控制器
 *
 * @author fengshuonan
 * @date 2017-08-23 16:02
 */
@Controller
@RequestMapping("/hello")
public class ExampleController extends BaseController {

    @Autowired
    SqlSession sqlSession;

    @RequestMapping("")
    public ResponseEntity hello(@RequestBody SimpleObject simpleObject) {
        System.out.println(simpleObject.getUser());
        return ResponseEntity.ok("请求成功!");
    }

    @RequestMapping("/say")
    public ResponseEntity<?> say() {
        String tabName = this.getPara("tbname");
        Map<String, String> paras = HttpKit.getRequestParameters();
        HttpServletRequest request = HttpKit.getRequest();
        SqlMapper sql = new SqlMapper(sqlSession);
        List<SysUser> result = sql.selectList("select   * from sys_user", SysUser.class);

        Object results=sql.selectList("select a.id,a.roleid,a.account,a.birthday,a.avatar,a.createtime,a.deptid,a.email,b.id as roleid,b.name as rolename from sys_user AS  a  INNER JOIN  sys_role as b \n" +
                "on a.roleid=b.id");
        return ResponseEntity.ok(results);
    }
}
