package com.luna.payment.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luna.payment.service.PaymentSentinelService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author luna_mac
 * @date 2020-02-18 10:43
 */

@Slf4j
@RestController
@RequestMapping("/api/payment")
public class PaymentSentinelController {

    @Resource
    private PaymentSentinelService paymentSentinelService;

    @Value("${server.port}")
    private String                 serverPort;

    @GetMapping("/sentinel/{id}")
    public String paymentInfoSuccess(@PathVariable("id") Integer id) {
        log.info(serverPort + ": paymentInfoSuccess");
        return paymentSentinelService.paymentInfoSuccess(id);
    }

    /**
     * 单方法延迟
     * 
     * @param time
     * @param id
     * @return
     */
    @GetMapping("/sentinel/timeout/single/{time}/{id}")
    public String paymentInfoTimeoutSingle(@PathVariable("time") Long time, @PathVariable("id") Integer id) {
        log.info(serverPort + ": paymentInfoTimeoutSingle");
        return paymentSentinelService.paymentInfoTimeoutSingle(time, id);
    }

    /**
     * 全局延迟
     * 
     * @param time
     * @param id
     * @return
     */
    @GetMapping("/sentinel/timeout/global/{time}/{id}")
    public String paymentInfoTimeoutGlobal(@PathVariable("time") Long time, @PathVariable("id") Integer id) {
        log.info(serverPort + ": paymentInfoTimeoutGlobal");
        return paymentSentinelService.paymentInfoTimeoutGlobal(time, id);
    }

    /**
     * 单方法降级
     * 
     * @param time
     * @param id
     * @return
     */
    @GetMapping("/sentinel/timeout/single/fallback/{time}/{id}")
    public String paymentInfoTimeoutSingleHandler(@PathVariable("time") Long time, @PathVariable("id") Integer id) {
        return paymentSentinelService.paymentInfoTimeoutSingleHandler(time, id);
    }

    /**
     * 全局降级
     * 
     * @return
     */
    @GetMapping("/sentinel/timeout/global/fallback")
    public String paymentInfoTimeoutGlobalHandler() {
        return paymentSentinelService.paymentInfoTimeoutGlobalHandler();
    }

    /**
     * 服务熔断
     * 
     * @param id
     * @return
     */
    @GetMapping("/sentinel/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentSentinelService.paymentCircuitBreaker(id);
    }

    /**
     * 服务熔断调用
     * 
     * @param id
     * @return
     */
    @GetMapping("/sentinel/circuit/fallback/{id}")
    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return paymentSentinelService.paymentCircuitBreakerFallback(id);
    }
}
