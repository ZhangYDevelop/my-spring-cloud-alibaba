package com.zy.alibaba.gateway.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @AUTHOR zhangy
 * 2020-06-26  12:08
 */

@Controller
public class LoginController {

    @RequestMapping({"/login", "/"})
    public String userLogin() {
        return "login";
    }
    @RequestMapping("/main")
    public String main() {
        return "main";
    }
}
