package com.luna.payment.controller;

import com.luna.payment.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author luna_mac
 * @date 2020-02-18 10:43
 */

@Slf4j
@RestController
@RequestMapping("/api/payment")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String                serverPort;

    @GetMapping("/hystrix/{id}")
    public String paymentInfoSuccess(@PathVariable("id") Integer id) {
        log.info(serverPort + ": paymentInfoSuccess");
        return paymentHystrixService.paymentInfoSuccess(id);
    }

    @GetMapping("/hystrix/timeout/{time}/{id}")
    public String paymentInfoTimeout(@PathVariable("time") Long time, @PathVariable("id") Integer id) {
        log.info(serverPort + ": paymentInfoTimeout");
        return paymentHystrixService.paymentInfoTimeout(time, id);
    }
}
