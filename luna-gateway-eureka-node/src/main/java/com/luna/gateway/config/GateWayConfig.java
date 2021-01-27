package com.luna.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luna@mac
 * @className GateWayConfig.java
 * @description TODO
 * @createTime 2021年01月27日 14:32:00
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder builder = routeLocatorBuilder.routes();

        builder.route("luna-baidu-news", r -> r.path("/guonei")
            .uri("http://news.baidu.com/guonei"));

        return builder.build();
    }
}
