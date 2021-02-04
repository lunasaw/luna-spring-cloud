package com.luna.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author luna
 * @date 2020-02-17 21:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderStorageNacosSeataApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderStorageNacosSeataApplication.class, args);
    }
}
