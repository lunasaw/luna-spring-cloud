package com.luna.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luna@mac
 * @className MyRule.java
 * @description TODO
 * @createTime 2021年01月24日 22:21:00
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        // 负载均衡规则定义为随机
        return new RandomRule();
    }
}