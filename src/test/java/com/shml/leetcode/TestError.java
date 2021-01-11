package com.shml.leetcode;

public class TestError {

    public String testError() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new SecurityException("123456", "测试异常！");
        }
        return "";
    }
}
