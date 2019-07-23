package com.shml.concurrent;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {

        queue.add(new Item(10));

        queue.add(new Item((60)));

        queue.add(new Item(20));

        queue.add(new Item(50));

        queue.add(new Item(30));

        queue.add(new Item(40));

        while (true) {

            Object poll = queue.poll();

            if (poll != null) {
                System.out.println(poll);
            } else {
                break;
            }

        }

    }

   static class Item {

        private int age;

        public Item(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

       @Override
       public String toString() {
           return "Item{" +
                   "age=" + age +
                   '}';
       }
   }

    private static PriorityQueue queue = new PriorityQueue(new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return o2.getAge() - o1.getAge();
        }
    });



}
