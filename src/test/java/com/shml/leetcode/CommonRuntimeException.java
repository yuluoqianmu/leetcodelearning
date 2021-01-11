package com.shml.leetcode;

public class CommonRuntimeException extends RuntimeException{

    private String code;
    private Object[] params;


    public CommonRuntimeException(String code, Object... params) {
        this.code = code;
        this.params = params;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
