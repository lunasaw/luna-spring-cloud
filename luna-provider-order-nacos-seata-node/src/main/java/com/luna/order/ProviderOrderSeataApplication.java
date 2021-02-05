package com.luna.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author luna
 * @date 2020-02-17 21:13
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.luna.order.feign")
public class ProviderOrderSeataApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderOrderSeataApplication.class, args);
    }
}
