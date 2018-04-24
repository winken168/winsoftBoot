package com.winsoft.db;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.winsoft.api.config.MybatisPlusConfig;
import com.winsoft.core.db.core.SqlMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;
@SpringBootApplication(scanBasePackages = {"com.winsoft.api"})
@ComponentScan(basePackages={"com.winsoft","com.winsoft.api"})
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = SpringBootSampleApplication.class)
@WebAppConfiguration

public class dbSQL {

    @Autowired
    private static SqlSession sqlSession;
    public static void main(String[] args) {

        System.out.println(sqlSession ==null);
        //DataSourceConfig ds=new DataSourceConfig();
        //SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        //sessionFactory.setDataSource(ds.getConn().);
        //SqlSession sqlsession= (SqlSession)sessionFactory.getObject();
     //   SqlMapper sql=new SqlMapper(sqlSession);
     //   Map<String,Object> result=sql.selectOne("select top 1 * from sys_user");

    }
}
