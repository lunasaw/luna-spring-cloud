package com.luna.payment.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luna@mac
 * @className OpenFeignConfiguration.java
 * @description TODO
 * @createTime 2021年01月25日 00:46:00
 */
@Configuration
public class OpenFeignConfiguration {

    @Bean
    Logger.Level openFeignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
