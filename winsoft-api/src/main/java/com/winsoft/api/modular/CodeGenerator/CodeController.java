package com.winsoft.api.modular.CodeGenerator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.winsoft.core.base.controller.BaseController;
import com.winsoft.core.datasource.DruidProperties;
//import com.winsoft.generator.Services.TableService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/code")
public class CodeController extends BaseController {

    private static String PREFIX = "/code";



    @Autowired
    private DruidProperties druidProperties;

    /**
     * 生成代码
     */
    @ApiOperation("生成代码")
    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    @ResponseBody
    public Object generate() {


        String oputdir="/Users/winken168/Desktop/code/";
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(oputdir);
       // gc.setOutputDir("D:\\tmp\\guns\\guns-rest\\src\\main\\java");//这里写你自己的java目录
        gc.setFileOverride(true);//是否覆盖
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("winken");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName(druidProperties.getDriverClassName());
        //dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(druidProperties.getUsername());
        dsc.setPassword(druidProperties.getPassword());
        dsc.setUrl(druidProperties.getUrl());
        //dsc.setUrl("jdbc:mysql://127.0.0.1:3306/rest?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix(new String[]{"_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[]{"sys_user","sys_role","sys_SQLCommand","sys_GridConfig"});

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        pc.setEntity("com.winsoft.api.modular.sys.model");
        pc.setMapper("com.winsoft.api.modular.sys.dao");
        pc.setXml("com.winsoft.api.modular.sys.dao.mapping");
        pc.setService("com.winsoft.api.modular.sys.service");       //本项目没用，生成之后删掉
        pc.setServiceImpl("com.winsoft.api.modular.sys.service");   //本项目没用，生成之后删掉
        pc.setController("com.winsoft.api.modular.sys.controller");    //本项目没用，生成之后删掉
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);

        // 执行生成
        mpg.execute();

        // 打印注入设置

        return SUCCESS_TIP;
    }

}
