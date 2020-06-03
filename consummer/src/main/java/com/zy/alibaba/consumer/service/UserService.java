package com.zy.alibaba.consumer.service;

import com.zy.alibaba.dubbo.api.IUserService;
import com.zy.alibaba.dubbo.api.model.SysUser;
import com.zy.alibaba.utils.ResponseBody;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Reference
    private IUserService userService;



    public ResponseBody<SysUser> getSysUserById(Long id) {
        return null;
    }

    public ResponseBody<SysUser> getSysUserByUserName(String  username) {
        return new ResponseBody<SysUser>().
                setData( userService.getSysUserByUserName(username)).setSuccess(true);
    }

    public Integer deleteSysUserById(Long id) {
        return null;
    }

    public Integer modifySysUser(SysUser sysUser) {
        return null;
    }

    public Integer addSysUser(SysUser sysUser) {
        return null;
    }
}
