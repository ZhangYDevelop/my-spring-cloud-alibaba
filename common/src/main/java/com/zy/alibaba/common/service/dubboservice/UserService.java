package com.zy.alibaba.common.service.dubboservice;

import com.zy.alibaba.common.mapper.UserMapper;
import com.zy.alibaba.dubbo.api.IUserService;
import com.zy.alibaba.dubbo.api.model.SysUser;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser getSysUserById(Long id) {
        return null;
    }

    @Override
    public SysUser getSysUserByUserName(String  username) {
        return userMapper.getUserByUserName(username);
    }

    @Override
    public Integer deleteSysUserById(Long id) {
        return null;
    }

    @Override
    public Integer modifySysUser(SysUser sysUser) {
        return null;
    }

    @Override
    public Integer addSysUser(SysUser sysUser) {
        return null;
    }
}
