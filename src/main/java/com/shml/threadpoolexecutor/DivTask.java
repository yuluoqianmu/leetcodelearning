package com.shml.threadpoolexecutor;

public class DivTask implements Runnable{

    int a,b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double result = a / b;
        System.out.println("result="+result);
    }
}
