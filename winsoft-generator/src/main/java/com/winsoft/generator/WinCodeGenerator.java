package com.winsoft.generator;

import com.winsoft.generator.config.GeneratorConfig;

public class WinCodeGenerator {
    public static void main(String[] args) {

        /**
         * Mybatis-Plus的代码生成器:
         *      mp的代码生成器可以生成实体,mapper,mapper对应的xml,service
         */
        GeneratorConfig gConfig = new GeneratorConfig();
        gConfig.doMpGeneration();

        /**
         * adi的生成器:
         *      adi的代码生成器可以生成controller,html页面,页面对应的js
         */
        gConfig.doAdiGeneration();
    }
}
