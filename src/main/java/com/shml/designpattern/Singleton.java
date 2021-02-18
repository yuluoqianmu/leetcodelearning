package com.shml.designpattern;

public class Singleton {

    //vloatile防止重排序
    private static volatile Singleton singleton = null;

    private Singleton() { }

    public static Singleton getInstance() {

        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }

}
