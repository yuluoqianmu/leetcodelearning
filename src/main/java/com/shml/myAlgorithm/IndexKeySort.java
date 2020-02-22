package com.shml.myAlgorithm;

public class IndexKeySort {

    public static void indexKeySort(char[] strs) {

        int len = strs.length;
        int[] count = new int[257];

        char[] aux = new char[len];

        /**
         *
         */
        for (int i=0; i<len; i++) {
            count[strs[i]+1]++;
        }

        for (int r=0; r<256; r++) {
            count[r+1] += count[r];
        }

        for (int i=0; i<len; i++) {
            aux[count[strs[i]]++] = strs[i];
        }

        for (int i=0; i<len; i++) {
            strs[i] = aux[i];
        }

    }


    public static void main(String[] args) {
        char[] ch = new char[]{'d','a', 'c','f', 'f','b', 'd','b','f','b','e','a'};

        indexKeySort(ch);
        for (int i=0; i<ch.length; i++) {
            System.out.println(ch[i]);
        }
    }
}
