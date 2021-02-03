package com.luna.payment.controller;

import javax.annotation.Resource;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.luna.commons.entities.CommonResult;
import com.luna.payment.handler.SentinelHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
     * 限流后 自定义全局异常降级处理
     * 
     * @return
     */
    @GetMapping("/sentinel/customerHandler")
    @SentinelResource(value = "sentinel/customerHandler", blockHandlerClass = SentinelHandler.class,
        blockHandler = "handlerExceptionII")
    public CommonResult<String> customerBlockHandler() {
        return new CommonResult(200, "限流后 客户自定义异常处理", "customerBlockHandler----🉑️");
    }

    /**
     * rateLimit URL 限流
     *
     * @return
     */
    @GetMapping("/sentinel/rateLimit/get")
    @SentinelResource(value = "sentinel/rateLimit/get")
    public CommonResult<String> rateLimit() {
        return new CommonResult(200, "rateLimit 按url限流", "rateLimit----🉑️");
    }

    /**
     * byResource 资源名称限流
     *
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/sentinel/byResource/get")
    @SentinelResource(value = "sentinel/byResource/get", blockHandler = "byResourceRollback")
    public CommonResult<String> byResource(@RequestParam(value = "p1", required = false) String p1,
        @RequestParam(value = "p2", required = false) String p2) {
        return new CommonResult(200, "resource 限流 参数：" + p1 + "===" + p2, " byResource----🉑️");
    }

    public CommonResult<String> byResourceRollback(String p1, String p2, BlockException blockException) {
        return new CommonResult(444, blockException.getClass().getName(), "byResourceRollback----不🉑️");
    }

    /**
     * hostKey 资源名称限流
     * 
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/sentinel/hostkey/get")
    @SentinelResource(value = "sentinel/hostKey/get", blockHandler = "getHostKeyRollback")
    public CommonResult<String> getHostKey(@RequestParam(value = "p1", required = false) String p1,
        @RequestParam(value = "p2", required = false) String p2) {
        return new CommonResult(200, p1 + p2, "getHostKeyRollback----不🉑️");
    }

    public CommonResult<String> getHostKeyRollback(String p1, String p2, BlockException exception) {
        return new CommonResult(444, exception.getMessage(), "getHostKeyRollback----不🉑️");
    }
}
