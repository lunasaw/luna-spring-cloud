package com.luna.payment.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luna_mac
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageService {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者1号，serverport: " + serverPort + "，接受到的消息：" + message.getPayload());
    }
}