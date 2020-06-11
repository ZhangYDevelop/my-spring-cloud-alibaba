package com.zy.alibaba.common.service.impl;

import com.zy.alibaba.common.mapper.UserMapper;
import com.zy.alibaba.dubbo.api.model.SysUser;
import com.zy.alibaba.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCaheUserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "consumer:system-user" ,key ="'getSysUserByUserName-' + #username", unless="#result == null")
    public ResponseBody getSysUserByUserName(String  username) {
        SysUser sysUser = userMapper.getUserByUserName(username);
        return  ResponseBody.ok(sysUser);
    }
}
