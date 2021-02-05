package com.luna.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author luna
 * @date 2020-02-17 21:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderAccountSeataApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderAccountSeataApplication.class, args);
    }
}
