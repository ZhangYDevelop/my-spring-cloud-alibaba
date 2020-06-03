package com.zy.alibaba.author.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginOutController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/loginOut")
    public String loginOut(@RequestParam("token") String token) {
        // 注销token
        if (consumerTokenServices.revokeToken(token)) {
            return  "true";
        } else {
            return  "false";
        }
    }
}
