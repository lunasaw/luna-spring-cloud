package com.luna.payment.controller;

import com.luna.payment.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author luna_mac
 * @date 2020-02-18 10:43
 */

@Slf4j
@RestController
@RequestMapping("/api/payment")
@DefaultProperties(defaultFallback = "paymentInfoTimeoutGlobalHandler")
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

    @GetMapping("/hystrix/timeout/single/{time}/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutSingleHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeoutSingle(@PathVariable("time") Long time, @PathVariable("id") Integer id) {
        log.info(serverPort + ": paymentInfoTimeoutSingle");
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentHystrixService.paymentInfoSuccess(id);
    }

    @GetMapping("/hystrix/timeout/global/{time}/{id}")
    @HystrixCommand(commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeoutGlobal(@PathVariable("time") Long time, @PathVariable("id") Integer id) {
        log.info(serverPort + ": paymentInfoTimeoutGlobal");
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentHystrixService.paymentInfoSuccess(id);
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
        log.info(serverPort + ": paymentInfoTimeoutSingleHandler");
        return paymentHystrixService.paymentInfoTimeoutSingleHandler(time, id);
    }

    /**
     * 全局降级
     * 
     * @return
     */
    @GetMapping("/hystrix/timeout/global/fallback")
    public String paymentInfoTimeoutGlobalHandler() {
        log.info(serverPort + ": paymentInfoTimeoutGlobalHandler");
        return paymentHystrixService.paymentInfoTimeoutGlobalHandler();
    }
}
