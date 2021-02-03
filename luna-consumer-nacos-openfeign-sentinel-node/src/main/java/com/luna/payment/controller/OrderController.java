package com.luna.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luna.commons.entities.CommonResult;
import com.luna.commons.entities.Payment;
import com.luna.payment.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author luna_mac
 */
@Slf4j
@RestController
@RequestMapping("/api/payment")
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping(value = "/timeout/{time}")
    public CommonResult<String> paymentTimeout(@PathVariable("time") Long time) {
        return paymentService.paymentTimeout(time);
    }
}