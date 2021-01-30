package com.luna.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author luna
 * @date 2020-02-17 21:13
 * http://server:port/context-path/hystrix
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
public class ConsumerEurekaApplicationHystrixDashboard {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerEurekaApplicationHystrixDashboard.class, args);
    }
}
