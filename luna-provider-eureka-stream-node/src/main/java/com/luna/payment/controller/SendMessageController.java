package com.luna.payment.controller;

import com.luna.payment.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author luna_mac
 */
@RestController
@RequestMapping("/api/message")
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String sendMessage() {
        return messageProvider.send();
    }
}