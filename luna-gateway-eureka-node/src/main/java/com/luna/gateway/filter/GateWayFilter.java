package com.luna.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author luna_mac
 */
@Component
@Slf4j
public class GateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("------come in MyGlobalFilter : " + new Date());
        String id = exchange.getRequest().getQueryParams().getFirst("id");
        // 合法性检验
        int i = Integer.parseInt(id);
        if (i <= 1) {
            log.info("----id<=1,非法用户，请求不被接受");
            // 设置 response 状态码 因为在请求之前过滤的，so就算是返回NOT_FOUND 也不会返回错误页面
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            // 完成请求调用
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 返回值是加载顺序，一般全局的都是第一位加载
     * 
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}