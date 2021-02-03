package com.luna.payment.service.impl;

import com.luna.commons.entities.CommonResult;
import com.luna.commons.entities.Payment;
import com.luna.payment.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author luna@mac
 * @className PaymentFallback.java
 * @description TODO
 * @createTime 2021年02月04日 01:00:00
 */
@Component
public class PaymentServiceFallbackImpl implements PaymentService {

    @Override
    public CommonResult<Integer> create(Payment payment) {
        return new CommonResult<>(400, "服务熔断降级处理", 0);
    }

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(400, "服务熔断降级处理", new Payment());
    }

    @Override
    public CommonResult<String> paymentTimeout(Long time) {
        return new CommonResult<>(400, "服务熔断降级处理", "请稍后再试  不🉑️");
    }
}
