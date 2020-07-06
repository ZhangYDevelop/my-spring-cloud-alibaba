package com.zy.alibaba.gateway.filter;


import com.alibaba.fastjson.JSONObject;
import com.zy.alibaba.utils.httputils.HttpUtils;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.*;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import springfox.documentation.spring.web.json.Json;

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

    private List<String> noTokenUrl = Arrays.asList("/v2/api-docs", "/api/login");

    @Value("${oauth2.authorization.check-token-access}")
    private String checkTokenUrl ;

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
        String username = checkToken(tokens.get(0));
        if (StringUtils.isEmpty(username)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // 设置用户信息
        ServerHttpRequest request = exchange.getRequest().mutate().header("username", username).build();
        return chain.filter(exchange.mutate().request(request).build());
    }

    private String checkToken(String token) {
        Object username = "";
        String url = "http://localhost:8004/oauth/check_token?token=" + token;
        String str =  HttpUtils.sendGetByHttpClient(checkTokenUrl + "?token=" +  token);
        if (!StringUtils.isEmpty(str)) {
            JSONObject object = JSONObject.parseObject(str);
            username = object.get("user_name");
        }
        System.out.println(str);
        if (username != null ) {
            return username.toString();
        } else {
            return "";
        }
    }

    @Override
    public int getOrder() {
        return -1;
    }


}
