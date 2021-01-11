package com.shml.leetcode;

import org.junit.Test;

public class MyExceptionTest {
    public static void main(String[] args) {
        try {
            TestError error = new TestError();
            error.testError();
        } catch (CommonRuntimeException e) {
            System.out.println(e.getCode());
        }
    }
}
