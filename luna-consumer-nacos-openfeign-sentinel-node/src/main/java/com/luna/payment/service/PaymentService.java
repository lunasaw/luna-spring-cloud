package com.luna.payment.service;

import com.luna.commons.entities.CommonResult;
import com.luna.commons.entities.Payment;
import com.luna.payment.service.impl.PaymentServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author luna
 * @date 2020-02-18 10:40
 */
@FeignClient(value = "luna-provider-payment-sentinel", fallback = PaymentServiceFallbackImpl.class)
@Component
public interface PaymentService {

    String PROVIDER_PAYMENT = "/provider-payment/api/payment";

    /**
     * 创建
     *
     * @param payment
     * @return
     */
    @PostMapping(value = PROVIDER_PAYMENT + "/create")
    public CommonResult<Integer> create(@RequestBody Payment payment);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = PROVIDER_PAYMENT + "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 超时控制
     *
     * @param time
     * @return
     */
    @GetMapping(value = PROVIDER_PAYMENT + "/timeout/{time}")
    public CommonResult<String> paymentTimeout(@PathVariable("time") Long time);
}
