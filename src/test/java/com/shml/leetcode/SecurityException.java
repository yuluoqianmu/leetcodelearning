package com.shml.leetcode;

public class SecurityException extends CommonRuntimeException{

    public SecurityException(String code, Object... params) {
        super(code, params);
    }
}
