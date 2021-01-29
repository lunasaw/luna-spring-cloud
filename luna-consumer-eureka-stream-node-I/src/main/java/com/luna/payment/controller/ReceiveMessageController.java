package com.luna.payment.controller;

import com.luna.payment.service.ReceiveMessageService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luna@mac
 * @className ReceiveMessageController.java
 * @description TODO
 * @createTime 2021年01月29日 17:03:00
 */
@RestController
@RequestMapping("api/message")
public class ReceiveMessageController {

    @GetMapping("/receive")
    public String receiveMessage() {
        return "";
    }
}
