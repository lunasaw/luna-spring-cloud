package com.luna.payment.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author luna
 * @date 2020-02-18 10:40
 */
@Service
public class PaymentService {

    /**
     * 线程控制
     * 
     * @param id
     * @return
     */
    public String paymentInfoSuccess(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfoSuccess，id:" + id;
    }

    /**
     * 超时访问的方法
     * 
     * @param time 超时时长
     * @param id 线程Id
     * @return
     */
    public String paymentInfoTimeoutGlobal(Long time, Integer id) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfoTimeoutGlobal，id:" + id + "耗时" + time + "秒钟--";
    }

    public String paymentInfoTimeoutSingle(Long time, Integer id) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfoTimeoutSingle，id:" + id + "耗时" + time + "秒钟--";
    }

    /**
     * 特殊超时访问的方法 降级处理
     *
     * @param id 线程Id
     * @return
     */
    public String paymentInfoTimeoutSingleHandler(Long time, Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfoTimeoutSingleHandler，id:" + id + "耗时" + time
            + "秒钟-- 😭";
    }

    /**
     * 全局超时访问的方法 降级处理
     *
     * @return
     */
    public String paymentInfoTimeoutGlobalHandler() {
        return "系统错误，请稍后再试 😭";
    }

    /**
     * 服务熔断
     * 
     * @param id
     * @return
     */
    public String paymentCircuitBreaker(Integer id) {
        // 模拟发生异常
        if (id < 0) {
            throw new RuntimeException("*****id，不能为负数");
        }
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + IdUtil.simpleUUID();
    }

    /**
     * 熔断调用
     * 
     * @param id
     * @return
     */
    public String paymentCircuitBreakerFallback(Integer id) {
        return "id 不能为负数，请稍后再试.... 😭";
    }
}
