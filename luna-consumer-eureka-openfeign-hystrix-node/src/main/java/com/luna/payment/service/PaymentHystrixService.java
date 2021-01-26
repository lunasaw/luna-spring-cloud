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
    String paymentInfoSuccess(@PathVariable("id") Integer id);

    /**
     * 单方法延迟
     * 
     * @param time
     * @param id
     * @return
     */
    @GetMapping(PROVIDER_PAYMENT + "/hystrix/timeout/single/{time}/{id}")
    String paymentInfoTimeoutSingle(@PathVariable("time") Long time, @PathVariable("id") Integer id);

    /**
     * 全局延迟
     * 
     * @param time
     * @param id
     * @return
     */
    @GetMapping(PROVIDER_PAYMENT + "/hystrix/timeout/global/{time}/{id}")
    String paymentInfoTimeoutGlobal(@PathVariable("time") Long time, @PathVariable("id") Integer id);

    /**
     * 单方法降级
     * 
     * @param time
     * @param id
     * @return
     */
    @GetMapping(PROVIDER_PAYMENT + "/hystrix/timeout/single/fallback/{time}/{id}")
    String paymentInfoTimeoutSingleHandler(@PathVariable("time") Long time, @PathVariable("id") Integer id);

    /**
     * 全局降级
     * 
     * @return
     */
    @GetMapping(PROVIDER_PAYMENT + "/hystrix/timeout/global/fallback")
    String paymentInfoTimeoutGlobalHandler();
}
