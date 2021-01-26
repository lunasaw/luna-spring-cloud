package com.luna.payment.service;

import org.springframework.stereotype.Component;

/**
 * @author luna@mac
 * @className OrderFallbackService.java
 * @description TODO 当服务端不可用时 调用本地方法
 * @createTime 2021年01月26日 15:41:00
 */
@Component
public class OrderFallbackServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentInfoSuccess(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfoSuccess，id:" + id;
    }

    @Override
    public String paymentInfoTimeoutSingle(Long time, Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfoTimeoutSingle，id:" + id + "耗时" + time + "秒钟--";
    }

    @Override
    public String paymentInfoTimeoutGlobal(Long time, Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfoTimeoutGlobal，id:" + id + "耗时" + time + "秒钟--";
    }

    @Override
    public String paymentInfoTimeoutSingleHandler(Long time, Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfoTimeoutSingleHandler，id:" + id + "耗时" + time
            + "秒钟-- 😭";
    }

    @Override
    public String paymentInfoTimeoutGlobalHandler() {
        return "系统错误，请稍后再试 😭";
    }
}
