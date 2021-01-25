package com.luna.payment.controller;

import com.luna.commons.entities.CommonResult;
import com.luna.commons.entities.Payment;
import com.luna.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author luna_mac
 * @date 2020-02-18 10:43
 */

@Slf4j
@RestController
@RequestMapping("/api/payment")
public class PaymentHystrixController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String         serverPort;

    @GetMapping("/hystrix/{id}")
    public String paymentInfoSuccess(@PathVariable("id") Integer id) {
        log.info(serverPort + ": paymentInfoSuccess");
        return paymentService.paymentInfoSuccess(id);
    }

    @GetMapping("/hystrix/timeout/single/{time}/{id}")
    public String paymentInfoTimeoutSingle(@PathVariable("time") Long time, @PathVariable("id") Integer id) {
        log.info(serverPort + ": paymentInfoTimeout");
        return paymentService.paymentInfoTimeoutSingle(time, id);
    }

    @GetMapping("/hystrix/timeout/global/{time}/{id}")
    public String paymentInfoTimeoutGlobal(@PathVariable("time") Long time, @PathVariable("id") Integer id) {
        log.info(serverPort + ": paymentInfoTimeout");
        return paymentService.paymentInfoTimeoutGlobal(time, id);
    }
}
