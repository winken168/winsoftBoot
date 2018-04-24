package com.winsoft.api;

import com.winsoft.api.modular.auth.util.JwtTokenUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.winsoft.api"})
@ComponentScan(basePackages={"com.winsoft","com.winsoft.api"})
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);


    }
}
