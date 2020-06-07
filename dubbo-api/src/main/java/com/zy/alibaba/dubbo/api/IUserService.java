package com.zy.alibaba.dubbo.api;


import com.zy.alibaba.dubbo.api.model.SysUser;
import com.zy.alibaba.utils.ResponseBody;

@SuppressWarnings("all")
public interface IUserService {

    ResponseBody getSysUserById(Long id);

    ResponseBody getSysUserByUserName(String username);

    ResponseBody deleteSysUserById(Long id);

    ResponseBody modifySysUser(SysUser sysUser);

    ResponseBody addSysUser(SysUser sysUser);

}
