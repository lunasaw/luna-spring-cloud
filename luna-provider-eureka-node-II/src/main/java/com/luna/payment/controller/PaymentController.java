package com.luna.payment.controller;

import com.luna.commons.entities.CommonResult;
import com.luna.commons.entities.Payment;
import com.luna.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author luna_mac
 * @date 2020-02-18 10:43
 */

@Slf4j
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService  paymentService;

    @Value("${server.port}")
    private String          serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);

        if (result > 0) {
            return new CommonResult<Integer>(200, "插入数据库成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult<Integer>(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功,serverPort:  " + serverPort, payment);
        } else {
            return new CommonResult<Payment>(444, "没有对应记录,查询ID: " + id, null);
        }
    }

    @GetMapping(value = "/timeout/{time}")
    public CommonResult<String> paymentTimeout(@PathVariable("time") Long time) {
        try {
            TimeUnit.SECONDS.sleep(time);
            return new CommonResult<String>(200, ": 超时控制成功", time.toString());
        } catch (InterruptedException e) {
            return new CommonResult<String>(444, ": 超时控制失败", e.getMessage());
        }
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element: " + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("LUNA-PROVIDER-PAYMENT");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t"
                    + instance.getUri());
        }

        return this.discoveryClient;
    }
}
