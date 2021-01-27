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
@DefaultProperties(defaultFallback = "paymentInfoTimeoutGlobalHandler")
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

    /**
     * 单方法延迟
     * 
     * @param time
     * @param id
     * @return
     */
    @GetMapping("/hystrix/timeout/single/{time}/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutSingleHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeoutSingle(@PathVariable("time") Long time, @PathVariable("id") Integer id) {
        log.info(serverPort + ": paymentInfoTimeoutSingle");
        return paymentService.paymentInfoTimeoutSingle(time, id);
    }

    /**
     * 全局延迟
     * 
     * @param time
     * @param id
     * @return
     */
    @GetMapping("/hystrix/timeout/global/{time}/{id}")
    @HystrixCommand(commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeoutGlobal(@PathVariable("time") Long time, @PathVariable("id") Integer id) {
        log.info(serverPort + ": paymentInfoTimeoutGlobal");
        return paymentService.paymentInfoTimeoutGlobal(time, id);
    }

    /**
     * 单方法降级
     * 
     * @param time
     * @param id
     * @return
     */
    @GetMapping("/hystrix/timeout/single/fallback/{time}/{id}")
    public String paymentInfoTimeoutSingleHandler(@PathVariable("time") Long time, @PathVariable("id") Integer id) {
        return paymentService.paymentInfoTimeoutSingleHandler(time, id);
    }

    /**
     * 全局降级
     * 
     * @return
     */
    @GetMapping("/hystrix/timeout/global/fallback")
    public String paymentInfoTimeoutGlobalHandler() {
        return paymentService.paymentInfoTimeoutGlobalHandler();
    }

    /**
     * 服务熔断
     * 
     * @param id
     * @return
     */
    @GetMapping("/hystrix/circuit/{id}")
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 失败率达到多少后跳闸
        // 整体意思：10秒内 10次请求，有6次失败，就跳闸 10秒后恢复检查
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.paymentCircuitBreaker(id);
    }

    /**
     * 服务熔断调用
     * 
     * @param id
     * @return
     */
    @GetMapping("/hystrix/circuit/fallback/{id}")
    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return paymentService.paymentCircuitBreakerFallback(id);
    }
}
