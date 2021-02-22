package com.shml.designpattern;

public class SingletonInnerClass {

    private SingletonInnerClass() {}

    private static class InnerClass {
        private static final SingletonInnerClass SINGLETON = new SingletonInnerClass();
    }

    public static final SingletonInnerClass getInstance() {
        return InnerClass.SINGLETON;
    }
}
