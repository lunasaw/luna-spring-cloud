package com.luna.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author luna@mac
 * @className CloudConfigServerApplicatiom.java
 * @description TODO
 * @createTime 2021年01月28日 13:02:00
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CloudConfigServerApplicatiom {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServerApplicatiom.class, args);
    }
}
