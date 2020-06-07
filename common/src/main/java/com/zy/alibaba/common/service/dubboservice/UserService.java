package com.zy.alibaba.common.service.dubboservice;

import com.zy.alibaba.common.mapper.UserMapper;
import com.zy.alibaba.dubbo.api.IUserService;
import com.zy.alibaba.dubbo.api.model.SysUser;
import com.zy.alibaba.utils.ResponseBody;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseBody getSysUserById(Long id) {
        return null;
    }

    @Override
    public ResponseBody getSysUserByUserName(String  username) {
        SysUser sysUser = userMapper.getUserByUserName(username);
        return  ResponseBody.ok(sysUser);
    }

    @Override
    public ResponseBody deleteSysUserById(Long id) {
        return null;
    }

    @Override
    public ResponseBody modifySysUser(SysUser sysUser) {
        return null;
    }

    @Override
    public ResponseBody addSysUser(SysUser sysUser) {
        return null;
    }
}
