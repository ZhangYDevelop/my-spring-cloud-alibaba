package com.zy.alibaba.common.mapper;

import com.zy.alibaba.dubbo.api.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where username = #{username}")
    SysUser getUserByUserName(@Param("username") String username);
}
