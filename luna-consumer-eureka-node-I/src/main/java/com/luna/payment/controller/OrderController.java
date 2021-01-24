package com.luna.payment.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.luna.commons.entities.CommonResult;
import com.luna.commons.entities.Payment;

import lombok.extern.slf4j.Slf4j;

/**
 * @author luna_mac
 */
@Slf4j
@RestController
@RequestMapping("/api/payment")
public class OrderController {

    /**
     * 远程调用的 地址
     */
    public static final String PAYMENT_URL        = "http://127.0.0.1:8001/provider-payment/api/payment";
    /**
     * EUREKA远程调用的 地址
     */
    public static final String EUREKA_PAYMENT_URL = "http://LUNA-PROVIDER-PAYMENT/provider-payment/api/payment";

    @Resource
    private RestTemplate       restTemplate;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        /**
         * param1 请求地址，param2 请求参数， param3 返回类型
         */
        return restTemplate.postForObject(EUREKA_PAYMENT_URL + "/create", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(EUREKA_PAYMENT_URL + "/get/" + id, CommonResult.class);
    }

    @GetMapping("/forEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id) {

        ResponseEntity<CommonResult> entity =
            restTemplate.getForEntity(EUREKA_PAYMENT_URL + "/get/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }
}