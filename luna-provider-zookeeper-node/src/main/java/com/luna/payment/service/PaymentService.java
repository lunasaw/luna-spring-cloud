package com.luna.payment.service;

import com.luna.commons.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author luna
 * @date 2020-02-18 10:40
 */
public interface PaymentService {

    /**
     * 创建
     *
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);
}
