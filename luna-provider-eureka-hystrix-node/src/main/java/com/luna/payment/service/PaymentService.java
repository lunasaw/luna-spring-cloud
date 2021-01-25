package com.luna.payment.service;

import com.luna.commons.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author luna
 * @date 2020-02-18 10:40
 */
@Service
public class PaymentService {

    /**
     * 可以正常访问的方法
     * 
     * @param id
     * @return
     */
    public String paymentInfoSuccess(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfoSuccess，id:" + id;
    }

    /**
     * 超时访问的方法
     */
    public String paymentInfoTimeout(Integer id) {
        int interTime = 3;
        try {
            TimeUnit.SECONDS.sleep(interTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfo_Timeout，id:" + id + "耗时" + interTime + "秒钟--";
    }
}
