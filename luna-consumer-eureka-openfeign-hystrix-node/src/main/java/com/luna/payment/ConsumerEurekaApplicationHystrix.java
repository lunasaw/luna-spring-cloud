package com.luna.payment;

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
@EnableFeignClients(basePackages = "com.luna.payment.service")
public class ConsumerEurekaApplicationHystrix {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerEurekaApplicationHystrix.class, args);
    }
}
