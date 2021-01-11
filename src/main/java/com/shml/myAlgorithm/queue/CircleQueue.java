package com.shml.myAlgorithm.queue;

public class CircleQueue {


    private String[] items;
    //数组大小
    private int n = 0;

    private int head = 0;

    private int tail = 0;


    public CircleQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }


    public boolean enqueue(String item) {

        //队列已满
        if ((tail + 1) % n == head)
            return false;

        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }



    public String dequeue() {
        //队列为空
        if (head == tail)
            return null;

        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }
}
