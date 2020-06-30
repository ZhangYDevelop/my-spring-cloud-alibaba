package com.zy.alibaba.gateway.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.netty.http.server.HttpServerResponse;

/**
 * @AUTHOR zhangy
 * 2020-06-26  12:08
 */

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    public String userLogin() {


        return "/login";
    }
}
