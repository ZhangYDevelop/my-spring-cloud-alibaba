package com.zy.alibaba.consumer.service.mock;

import com.zy.alibaba.dubbo.api.IUserService;
import com.zy.alibaba.dubbo.api.model.SysUser;
import com.zy.alibaba.utils.ResponseBody;

/**
 * 在服务不可用的情况下，服务熔断，返回兜底数据
 */
public class UserMockService implements IUserService {
    @Override
    public ResponseBody getSysUserById(Long id) {
        return null;
    }

    @Override
    public ResponseBody getSysUserByUserName(String username) {
        return new ResponseBody().setSuccess(true).setMsg("Sorry, 服务不可用，稍后再试");
    }

    @Override
    public ResponseBody deleteSysUserById(Long id) {
        return new ResponseBody().setSuccess(true).setMsg("Sorry, 服务不可用，稍后再试");
    }

    @Override
    public ResponseBody modifySysUser(SysUser sysUser) {
        return new ResponseBody().setSuccess(true).setMsg("Sorry, 服务不可用，稍后再试");
    }

    @Override
    public ResponseBody addSysUser(SysUser sysUser) {
        return new ResponseBody().setSuccess(true).setMsg("Sorry, 服务不可用，稍后再试");
    }
}
