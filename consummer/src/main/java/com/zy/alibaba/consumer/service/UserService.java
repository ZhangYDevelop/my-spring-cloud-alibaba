package com.zy.alibaba.consumer.service;

import com.zy.alibaba.dubbo.api.IUserService;
import com.zy.alibaba.dubbo.api.model.SysUser;
import com.zy.alibaba.utils.ResponseBody;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("all")
public class UserService {

    @Reference(mock = "com.zy.alibaba.consumer.service.mock.UserMockService", cluster = "failfast")
    private IUserService userService;

    public ResponseBody<SysUser> getSysUserById(Long id) {
        return null;
    }

    public ResponseBody<SysUser> getSysUserByUserName(String  username) {
        return userService.getSysUserByUserName(username);
    }

    public ResponseBody deleteSysUserById(Long id) {
        return null;
    }

    public ResponseBody modifySysUser(SysUser sysUser) {
        return null;
    }

    public ResponseBody addSysUser(SysUser sysUser) {
        return null;
    }
}
