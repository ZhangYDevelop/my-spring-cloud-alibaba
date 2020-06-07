package com.zy.alibaba.author.exception;

import org.springframework.security.core.AuthenticationException;

public class ClientNotFoundException extends AuthenticationException {
    public ClientNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public ClientNotFoundException(String msg) {
        super(msg);
    }

}
