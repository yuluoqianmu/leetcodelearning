package com.shml.threadpoolexecutor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DivTaskTest {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS,
                new SynchronousQueue<>());

        /*for (int i=0; i<5; i++) {
            poolExecutor.submit(new DivTask(100, i));
        }*/
        for (int i=0; i<5; i++) {
            poolExecutor.execute(new DivTask(100, i));
        }
    }
}
