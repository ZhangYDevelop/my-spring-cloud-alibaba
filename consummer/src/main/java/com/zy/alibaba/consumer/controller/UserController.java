package com.zy.alibaba.consumer.controller;

import com.zy.alibaba.consumer.service.UserService;
import com.zy.alibaba.dubbo.api.model.SysUser;
import com.zy.alibaba.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userInfo")
    public ResponseBody<SysUser> getSysUserByUserName(@RequestParam("username") String username) {
       return  userService.getSysUserByUserName(username);
    }
}
