package com.luna.payment.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author luna
 * @date 2020-02-18 10:40
 */
@FeignClient(value = "luna-provider-payment-hystrix")
@Component
public interface PaymentHystrixService {

    String PROVIDER_PAYMENT = "/provider-payment/api/payment";

    /**
     * 线程控制
     * 
     * @param id
     * @return
     */
    @GetMapping(PROVIDER_PAYMENT + "/hystrix/{id}")
    public String paymentInfoSuccess(@PathVariable("id") Integer id);

    /**
     * 线程超时控制
     * 
     * @param time
     * @param id
     * @return
     */
    @GetMapping(PROVIDER_PAYMENT + "/hystrix/timeout/{time}/{id}")
    public String paymentInfoTimeout(@PathVariable("time") Long time, @PathVariable("id") Integer id);
}
