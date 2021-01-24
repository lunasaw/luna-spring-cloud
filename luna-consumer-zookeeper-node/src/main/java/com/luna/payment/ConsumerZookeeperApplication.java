package com.luna.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author luna
 * @date 2020-01-17 21:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZookeeperApplication.class, args);
    }
}
