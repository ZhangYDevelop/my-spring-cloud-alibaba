package com.zy.alibaba.utils.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * @AUTHOR zhangy
 * 2020-06-07  15:29
 */
public class SecurityUserHelper {

    /**
     *
     * @return
     */
    public static Authentication getCurrentAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前用户名
     * @return
     */
    public static String getCurrentAuthorName() {
        return getCurrentAuthentication().getName();
    }
}
