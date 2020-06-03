package com.zy.alibaba.dubbo.api;


import com.zy.alibaba.dubbo.api.model.SysUser;

public interface IUserService {

    SysUser getSysUserById(Long id);

    SysUser getSysUserByUserName(String username);

    Integer deleteSysUserById(Long id);

    Integer modifySysUser(SysUser sysUser);

    Integer addSysUser(SysUser sysUser);

}
