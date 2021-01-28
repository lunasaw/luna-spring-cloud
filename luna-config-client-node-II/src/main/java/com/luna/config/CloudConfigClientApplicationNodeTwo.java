package com.luna.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author luna@mac
 * @className com.luna.config.CloudConfigClientApplication.java
 * @description TODO
 * @createTime 2021年01月28日 13:39:00
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClientApplicationNodeTwo {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClientApplicationNodeTwo.class, args);
    }

}
