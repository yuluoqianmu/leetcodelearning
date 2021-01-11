package com.shml.myAlgorithm.queue;

public class ArrayQueue {

    private String[] items;
    //数组大小
    private int n;
    //队头下标
    private int head;
    //队尾下标
    private int tail;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队操作
    /*public boolean enqueue(String item) {
        if (tail == n)
            return false;
        items[tail] = item;
        ++tail;
        return true;
    }*/

    //带数据搬移的入队操作
    public boolean enqueue(String item) {
        if (tail == n) {
            if (head == 0)
                return false;
            for (int i=head; i<tail; ++i) {
                items[i-head] = items[i];
            }
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;
    }


    //出队操作
    public String dequeue() {
        if (head == tail)
            return null;
        String item = items[head];
        ++head;
        return item;
    }


}
