package com.zy.alibaba.gateway.filter;


import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 过滤掉所有非法路由
 */
@Configuration
public class RouteFilter implements GlobalFilter, Ordered {

    @Autowired
    private  DiscoveryClient client;

    private List<String> noTokenUrl = Arrays.asList("/v2/api-docs");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getPath().pathWithinApplication().toString();

        HttpHeaders headers =  exchange.getRequest().getHeaders();
        List<String> tokens = headers.get("access_token");


        //放行不需要严重url
        List<String> tempNoTokenUrl = noTokenUrl.stream().filter(item -> path.contains(item)).collect(Collectors.toList());
        if (tempNoTokenUrl !=null && tempNoTokenUrl.size() > 0) {
            return chain.filter(exchange);
        }
        if (tokens == null || tokens.size() <= 0) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }
        // 验证token的有效性
        boolean flag = checkToken(tokens.get(0));
        if (!flag) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    private boolean checkToken(String token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:8004/oauth/check_token?token=" + token)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body().toString());
            }

            response.body().close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public int getOrder() {
        return -1;
    }


}
