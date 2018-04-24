package com.winsoft.api;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * winsoft  Web api 程序启动类
 *
 * @author fengshuonan
 * @date 2017年9月29日09:00:42
 */
public class ApiServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApiServletInitializer.class);
    }

}
