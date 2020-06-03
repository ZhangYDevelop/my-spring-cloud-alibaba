package com.zy.alibaba.author.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/user")
public class UserController {

    @GetMapping("userInfo")
    public Principal getPrinicpal(Principal principal) {
        return principal;
    }
}
