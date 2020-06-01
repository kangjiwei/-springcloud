package com.gateway.util.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Created by rongrong on 2020/5/19.
 */
@Slf4j
@Component
public class PreFilter  implements GlobalFilter,Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpResponse response = exchange.getResponse();
        ServerHttpRequest request = exchange.getRequest();
        HttpStatus statusCode = response.getStatusCode();
        log.info("Response 20:{}",statusCode);
        log.info("网关--pre--RequestId:{}",request.getId());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 20;
    }
}