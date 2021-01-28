package com.luna.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author luna@mac
 * @className CloudConfigServerApplicatiom.java
 * @description TODO
 * @createTime 2021年01月28日 13:02:00
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigServerApplicatiom {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServerApplicatiom.class, args);
    }
}
