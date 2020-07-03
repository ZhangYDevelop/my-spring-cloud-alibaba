package com.zy.alibaba.gateway.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Configuration
@SuppressWarnings("all")
public class RedirectHandler {

    @Value("${github.login_url}")
    private String qqLoginUrl ;

    public Mono<ServerResponse>  loginQQUrl(ServerRequest serverRequest) {
        return ServerResponse.temporaryRedirect(URI.create(qqLoginUrl)).build();
    }

    public Mono<ServerResponse> loginWXUrl(ServerRequest serverRequest) {
        return ServerResponse.temporaryRedirect(URI.create("/main")).build();
    }
}
