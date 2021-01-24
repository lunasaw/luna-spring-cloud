package com.luna.payment;

import com.luna.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author luna
 * @date 2020-02-17 21:13
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "LUNA-PROVIDER-PAYMENT", configuration = MySelfRule.class)
public class ConsumerEurekaApplicationNodeOne {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerEurekaApplicationNodeOne.class, args);
    }
}
