package com.zy.alibaba.gateway.filter;

import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 过滤掉所有非法路由
 */
@Component
public class RouteFilter implements GlobalFilter, Ordered {

    @Autowired
    private  DiscoveryClient client;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getPath().pathWithinApplication().toString();

        List<String> list = client.getServices();
        // 过滤非法路由
        List<String> checkList =  list.stream().filter(item -> path.contains(item)).collect(Collectors.toList());
        if (checkList != null && checkList.size() <= 0) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
