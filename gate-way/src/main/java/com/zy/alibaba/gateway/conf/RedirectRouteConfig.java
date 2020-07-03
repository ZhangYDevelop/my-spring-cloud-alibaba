package com.zy.alibaba.gateway.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.server.*;

@Configuration
public class RedirectRouteConfig {

    @Value("${github.login_url}")
    private String qqLoginUrl;

    @Autowired
    private RedirectHandler redirectHandler;
    @Bean
    RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route(RequestPredicates.GET("/api/github/login"), redirectHandler::loginQQUrl);
    }
}
