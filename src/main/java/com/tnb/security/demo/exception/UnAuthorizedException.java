package com.tnb.security.demo.exception;

/**
 * 未授权异常
 * @author swen
 */
public class UnAuthorizedException extends RuntimeException {

    public UnAuthorizedException(String message) {
        super(message);
    }
}
