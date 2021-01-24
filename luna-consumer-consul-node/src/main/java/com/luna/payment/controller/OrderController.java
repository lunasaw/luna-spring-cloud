package com.luna.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/api/payment")
public class OrderController {

    /**
     * 远程调用的 地址
     */
    public static final String PAYMENT_URL           = "http://127.0.0.1:8004/provider-payment/api/payment";
    /**
     * ZOOKEEPER远程调用的地址 注意：此处luna-provider-payment 与eureka有大小写区别
     */
    public static final String ZOOKEEPER_PAYMENT_URL = "http://luna-provider-payment/provider-payment/api/payment";

    @Resource
    private RestTemplate       restTemplate;

    @RequestMapping("/consul")
    public String paymentInfo() {
        return restTemplate.getForObject(ZOOKEEPER_PAYMENT_URL + "/consul", String.class);
    }
}