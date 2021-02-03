package com.luna.payment.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luna.commons.entities.Payment;
import com.luna.payment.dao.PaymentDao;
import com.luna.payment.service.PaymentService;

/**
 * @author luna
 * @date 2020-02-18 10:40
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
