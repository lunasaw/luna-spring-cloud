package com.luna.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author luna
 * @date 2020-02-17 21:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConfigNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigNacosApplication.class, args);
    }
}
